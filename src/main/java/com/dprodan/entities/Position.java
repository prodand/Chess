package com.dprodan.entities;

import java.util.Objects;

public final class Position implements Comparable<Position> {

    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Objects.equals(x, position.x) &&
                Objects.equals(y, position.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Position[" +
                "x=" + x +
                ", y=" + y +
                ']';
    }

    @Override
    public int compareTo(Position o) {
        if(getX() != o.getX()) {
            return getX() - o.getX();
        }
        return getY() - o.getY();
    }
}
