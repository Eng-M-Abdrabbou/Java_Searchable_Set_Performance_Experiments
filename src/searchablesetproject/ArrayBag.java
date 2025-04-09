package searchablesetproject;


public final class ArrayBag<T> implements BagInterface<T>
{
        private final T[] bag;
	private int numberOfEntries;
        private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 25;
	// MODIFIED for the project requirement
	private static final int MAX_CAPACITY = 70000;

	public ArrayBag()
	{
		this(DEFAULT_CAPACITY);
	}

	public ArrayBag(int desiredCapacity)
	{
      if (desiredCapacity <= MAX_CAPACITY)
      {
         @SuppressWarnings("unchecked")
         T[] tempBag = (T[])new Object[desiredCapacity];
         bag = tempBag;
         numberOfEntries = 0;
         initialized = true;
      }
      else
         throw new IllegalStateException("Attempt to create a bag " +
                                         "whose capacity exceeds " +
                                         "allowed maximum.");
	}

	public boolean add(T newEntry)
	{
		checkInitialization();
      boolean result = true;
      if (isArrayFull())
      {
         result = false;
      }
      else
      {
         bag[numberOfEntries] = newEntry;
         numberOfEntries++;
      }
      return result;
	}

	public T[] toArray()
	{
		checkInitialization();
      @SuppressWarnings("unchecked")
      T[] result = (T[])new Object[numberOfEntries];
      for (int index = 0; index < numberOfEntries; index++)
      {
         result[index] = bag[index];
      }
      return result;
	}

	public boolean isEmpty()
	{
      return numberOfEntries == 0;
	}

	public int getCurrentSize()
	{
      return numberOfEntries;
	}

	public int getFrequencyOf(T anEntry)
	{
		checkInitialization();
      int counter = 0;
      for (int index = 0; index < numberOfEntries; index++)
      {
         if (anEntry.equals(bag[index]))
         {
            counter++;
         }
      }
      return counter;
	}

   public boolean contains(T anEntry)
	{
		checkInitialization();
      return getIndexOf(anEntry) > -1;
	}

	public void clear()
	{
      while (!isEmpty())
         remove();
	}

	public T remove()
	{
		checkInitialization();
      T result = removeEntry(numberOfEntries - 1);
      return result;
	}

	public boolean remove(T anEntry)
	{
		checkInitialization();
      int index = getIndexOf(anEntry);
      T result = removeEntry(index);
      return anEntry.equals(result);
	}

	private boolean isArrayFull()
	{
		return numberOfEntries >= bag.length;
	}

	private int getIndexOf(T anEntry)
	{
		int where = -1;
		boolean found = false;
		int index = 0;
      while (!found && (index < numberOfEntries))
		{
			if (anEntry.equals(bag[index]))
			{
				found = true;
				where = index;
			}
         index++;
		}
		return where;
	}

	private T removeEntry(int givenIndex)
	{
		T result = null;
		if (!isEmpty() && (givenIndex >= 0))
		{
         result = bag[givenIndex];
         int lastIndex = numberOfEntries - 1;
         bag[givenIndex] = bag[lastIndex];
         bag[lastIndex] = null;
         numberOfEntries--;
		}
      return result;
	}

   private void checkInitialization()
   {
      if (!initialized)
         throw new SecurityException("ArrayBag object is not initialized properly.");
   }
}

