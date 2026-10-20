The set() Method Corrupts size and Creates Gaps
The Issue: Inside set(), if a slot is null, you increment this.size += 1.

Why it breaks:

If your list is empty (size = 0) and you call set(3, "Hello"), it sets index 2 and increments size to 1. However, indices 0 and 1 remain null, meaning your list is no longer contiguous.

Subsequent calls to add() will insert elements at this.size (which is now 1), potentially overwriting holes or misaligning your element tracking. set() in a standard list should only modify existing elements within the active size, not arbitrarily inflate size and leave gaps.




1. Index 0 Causes ArrayIndexOutOfBoundsException
The Issue: Your isIndexInBounds(int index) method checks index >= 0. However, inside get() and set(), you access this.data[index - 1]. If a user passes index = 0, index - 1 evaluates to -1, throwing an ArrayIndexOutOfBoundsException.
