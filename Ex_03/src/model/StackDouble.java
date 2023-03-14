package model;

public class StackDouble {
	Stack stack;
	
	public StackDouble() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean isEmpty()
	{
		if (stack == null)
			return true;
		return false;
	}
	
	public void push(double data)
	{
		Stack node = new Stack();
		
		node.data = data;
		
		if (!isEmpty())
			node.next = stack;
		stack = node;
	}
	
	public double pop()
	{
		if (!isEmpty())
		{
			double value = stack.data;
			stack = stack.next;
			return value;
		}
		return 0;
	}

	public double top()
	{
		if (!isEmpty())
			return stack.data;
		return 0;
	}
	
	public double size()
	{
		int count = 0;
		if (!isEmpty())
		{
			Stack nodeAux = stack;
			count++;
			while (nodeAux.next != null)
			{
				nodeAux = nodeAux.next;
				count++;
			}
		}
		return count;
	}
	public double max()
	{
		double max = 0;
		
		if (!isEmpty())
		{
			Stack nodeAux = stack;
			max = nodeAux.data;
			while (nodeAux.next != null)
			{
				nodeAux = nodeAux.next;
				if (nodeAux.data > max)
					max = nodeAux.data;
			}
		}
		
		return max;
	}
	public double min()
	{
		double min = 0;
		
		if (!isEmpty())
		{
			Stack nodeAux = stack;
			min = nodeAux.data;
			while (nodeAux.next != null)
			{
				nodeAux = nodeAux.next;
				if (nodeAux.data < min)
					min = nodeAux.data;
			}
		}
		
		return min;
	}
}
