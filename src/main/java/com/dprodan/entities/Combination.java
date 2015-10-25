package com.dprodan.entities;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Objects;

public class Combination {

    private final int hash;
    private final String value;

    public Combination(String value) {
        this.hash = value.hashCode();
        this.value = value;
    }

    @Override
    public int hashCode() {
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Combination that = (Combination) o;
        return Objects.equals(hash, that.hash);
    }

    @Override
    public String toString() {
        return String.valueOf(hash) + " - " + value;
    }

    public String getValue() {
        return value;
    }

    public static class CombinationBuilder implements Cloneable {

        private LinkedList<PositionedPiece> chain;
        private final StringBuilder builder;

        public CombinationBuilder() {
            this(new StringBuilder(48), new LinkedList<>());
        }

        private CombinationBuilder(StringBuilder builder, LinkedList<PositionedPiece> chain) {
            this.chain = chain;
            this.builder = builder;
        }

        public CombinationBuilder add(PositionedPiece p) {
            ListIterator<PositionedPiece> it = chain.listIterator();
            int index = 0;
            boolean handled = false;
            while(it.hasNext()) {
                PositionedPiece piece = it.next();
                if(piece.compareTo(p) >= 0) {
                    it.previous();
                    it.add(p);
                    handled = true;
                    break;
                }
                index++;
            }
            if(!handled) {
                chain.add(p);
            }
            int offset = index * 3;
            builder.insert(offset, p.getType().name().charAt(0));
            builder.insert(++offset, p.getX());
            builder.insert(++offset, p.getY());
            return this;
        }

        public Combination build() {
            return new Combination(builder.toString());
        }

        @Override
        public CombinationBuilder clone() {
            return new CombinationBuilder(new StringBuilder(builder.toString()), new LinkedList<>(chain));
        }
    }

}
