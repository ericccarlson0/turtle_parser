# Simulation API

### (doc/UNDERSTANDING_API.md) Understanding API Questions
* They are pretty easy to use. Java Collections is commonly used and the methods / behavior is well defined.
* Mistakes using these collections are generally easy to avoid. Java Collections are easy to conceptualize so they are easy to work with.

* **Linked List**:
    * **6 Interfaces**: Serializable, Cloneable, Iterable, Collection, List, Dequeue, Queue
    * These interfaces provide for specific uses of a collection of objects, such as serializing (indexing), cloning, iterating, counting, and queueing.
    * **4 Super-classes**: AbstractSequentialList, AbstractList, AbstractCollection, Object
    * Each of these superclasses takes a carefult step in qualifying a certain type of object, making the least amount of possible assumptions at each step.

* **Set** has:
    * **9 concrete implementing classes**: AbstractSet, ConcurrentHashMap.KeySetView, ConcurrentSkipListSet, CopyOnWriteArraySet, EnumSet, HashSet, JobStateReasons, LinkedHashSet, and TreeSet. 
    * **3 subinterfaces** that may have their own implementing classes: EventSet, NavigableSet\<E\>, SortedSet\<E\>.
    * The number of implementing classes justifies it being an interface since there are clearly a wide variety of viable implementations for the behavior that the interface defines. 

* Example: Arraylists have *three* levels of super-classes:
    * **AbstractList**: a general framework for a list that is easy to implement and is backed by random access of data (not sequential access of data).
    * **AbstractCollection**: a general framework for any collection of objects, which are characterized by the fact that they are grouped together
    * **Object**: a general framework for any object, or bundle of data, with whatever sort of characteristics or methods is may possess

* The utility classes -- such as *Collections* -- are useful to provide default implementations for methods that could otherwide be overriden by various implemented classes. As a utility class, *Collections* provides uniform default behavior for sorting collections -- even though different classes may have different classes, having a utility class guarantess access to a uniform implementation. Moreover, it stands to reduce code duplication.


