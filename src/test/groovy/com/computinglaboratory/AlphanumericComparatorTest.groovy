package com.computinglaboratory

import spock.lang.Specification

class AlphanumericComparatorTest extends Specification {

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

    def "Compare with nulls"() {
        given:
            def list = ["test1aa", null]
        when:
            list.sort(new AlphanumericComparator())
        then:
            thrown NullPointerException;
    }
}
