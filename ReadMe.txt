Collections is a static class, and the reason why we don't use Collections.synchronizedMap or Set is it will be block the tasks
    and will perform in the thread order

ImmutableMap -> In Map.of there can only 10 key-value pairs that can accommodate
                An Immutable Map, on the other hand, contains its own private data and doesn’t allow modifications to it.
                Therefore, the data cannot change in any way once an instance of the Immutable Map is created.

                Using Map.ofEntries we can enter any number of key & value pair as follows:
                                                            Map.ofEntries(Map.entry("",))

Set Overview -> Set is a collection that cannot contain duplicate Elements, which means faster operations
                Set --> HashSet, LinkedHashSet, TreeSet, EnumSet
                Set gives un-ordered collection. To get in ordered collection, we have to use LinkedHashSet
                If we want in sorted order then we have to use, TreeSet
                Set.of can hold more values than Map.of, means we can add more than 10 values to the Set
