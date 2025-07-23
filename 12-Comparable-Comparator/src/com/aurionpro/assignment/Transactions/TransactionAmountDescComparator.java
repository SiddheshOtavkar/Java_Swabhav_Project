package com.aurionpro.assignment.Transactions;

import java.util.Comparator;

public class TransactionAmountDescComparator implements Comparator<Transaction> {

	@Override
	public int compare(Transaction o1, Transaction o2) {
		int amountCompare = Double.compare(o2.amount, o1.amount);
		if(amountCompare != 0)  //  not equal
		{
			return Double.compare(o2.amount, o1.amount);
		}
		return Integer.compare(o1.id, o2.id);
	}

}
