package io.github.kamilszewc.comparators

import spock.lang.Specification

class AlphanumericComparatorTest extends Specification {

    def "Default sort"() {
        given:
            def list = ["test1", "test10", "test2", "test20", "test3"]
        when:
            list.sort()
        then:
            list == ["test1", "test10", "test2", "test20", "test3"]
    }

    def "Basic sort 1"() {
        given:
            def list = ["test1", "test10", "test2", "test20", "test3"]
        when:
            list.sort(new AlphanumericComparator())
        then:
            list == ["test1", "test2", "test3", "test10", "test20"]
    }

    def "Basic sort 2"() {
        given:
            def list = ["test1a", "test10b", "test2c", "test20d", "test3e"]
        when:
            list.sort(new AlphanumericComparator())
        then:
            list == ["test1a", "test2c", "test3e", "test10b", "test20d"]
    }

    def "Basic sort 3"() {
        given:
            def list = ["etest1a", "dtest10b", "ctest2c", "btest20d", "atest3e"]
        when:
            list.sort(new AlphanumericComparator())
        then:
            list == ["atest3e", "btest20d", "ctest2c", "dtest10b", "etest1a"]
    }

    def "Basic sort 4"() {
        given:
            def list = ["test1aa", "test1a"]
        when:
            list.sort(new AlphanumericComparator())
        then:
            list == ["test1a", "test1aa"]
    }

    def "Basic sort 5"() {
        given:
        def list = ["Apple", "Banana", "123", "456"]
        when:
        list.sort(new AlphanumericComparator())
        then:
        list == ["123", "456", "Apple", "Banana"]
    }

    def "Basic sort 6"() {
        given:
        def list = ["Jabłuszko", "Śliweczka", "123", "456"]
        when:
        list.sort(new AlphanumericComparator())
        then:
        list == ["123", "456", "Jabłuszko", "Śliweczka"]
    }

    def "Basic sort 6"() {
        given:
        def list = ["ąśćńół2", "ąśćńół10", "ąśćńół20", "ąśćńół11"]
        when:
        list.sort(new AlphanumericComparator())
        then:
        list == ["ąśćńół2", "ąśćńół10", "ąśćńół11", "ąśćńół20"]
    }

    def "Compare with nulls"() {
        given:
            def list = ["test1aa", null]
        when:
            list.sort(new AlphanumericComparator())
        then:
            thrown NullPointerException
    }
}
