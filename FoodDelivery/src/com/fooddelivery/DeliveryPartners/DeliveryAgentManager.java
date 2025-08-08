package com.fooddelivery.DeliveryPartners;

import java.util.*;
import java.util.function.Supplier;

public class DeliveryAgentManager {

	private static final List<IDeliveryAgent> deliveryAgents = new ArrayList<>(
			Arrays.asList(new Swiggy(), new Zomato()));

	// Master agent types
	private static final Map<String, Supplier<IDeliveryAgent>> allAgentTypes = new LinkedHashMap<>();
	static {
		allAgentTypes.put("Swiggy", Swiggy::new);
		allAgentTypes.put("Zomato", Zomato::new);
		allAgentTypes.put("Zepto", Zepto::new);
	}

	public static List<IDeliveryAgent> getAgents() {
		return deliveryAgents;
	}

	public static void listAgents() {
		if (deliveryAgents.isEmpty()) {
			System.out.println("❌ No active agents.");
			return;
		}
		System.out.println("\n🚚 Active Delivery Agents:");
		int i = 1;
		for (IDeliveryAgent agent : deliveryAgents) {
			System.out.println(i++ + ". " + agent.getName());
		}
	}

	public static void addAgentByName(String name) {
		if (!allAgentTypes.containsKey(name)) {
			System.out.println("❌ Unknown agent type.");
			return;
		}

		for (IDeliveryAgent agent : deliveryAgents) {
			if (agent.getName().equalsIgnoreCase(name)) {
				System.out.println("❗ " + name + " is already added.");
				return;
			}
		}

		deliveryAgents.add(allAgentTypes.get(name).get());
		System.out.println("✅ " + name + " added successfully.");
	}

	public static void removeAgentByName(String name) {
		Iterator<IDeliveryAgent> iterator = deliveryAgents.iterator();
		while (iterator.hasNext()) {
			IDeliveryAgent agent = iterator.next();
			if (agent.getName().equalsIgnoreCase(name)) {
				iterator.remove();
				System.out.println("✅ " + name + " removed successfully.");
				return;
			}
		}
		System.out.println("❌ Agent not found.");
	}

	public static void listAvailableAgentsToAdd() {
		Set<String> current = new HashSet<>();
		for (IDeliveryAgent agent : deliveryAgents) {
			current.add(agent.getName());
		}

		System.out.println("\n➕ Available Agents to Add:");
		int index = 1;
		for (String name : allAgentTypes.keySet()) {
			if (!current.contains(name)) {
				System.out.println(index++ + ". " + name);
			}
		}

		if (index == 1) {
			System.out.println("✅ All agents are already added.");
		}
	}

	public static String getRandomAgent() {
		Random rand = new Random();
		return deliveryAgents.get(rand.nextInt(deliveryAgents.size())).getName();
	}

	public static Set<String> getAvailableAgentNamesToAdd() {
		Set<String> available = new LinkedHashSet<>(allAgentTypes.keySet());
		for (IDeliveryAgent agent : deliveryAgents) {
			available.remove(agent.getName());
		}
		return available;
	}

	public static Set<String> getActiveAgentNames() {
		Set<String> active = new LinkedHashSet<>();
		for (IDeliveryAgent agent : deliveryAgents) {
			active.add(agent.getName());
		}
		return active;
	}
}