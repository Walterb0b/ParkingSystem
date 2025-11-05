package main;

import java.util.Objects;

public class Car {
    private String numberplate;

    public Car(String numberplate){
        this.numberplate = numberplate;
    }

    public String getNumberplate() {
        return numberplate;
    }

    private static String norm(String s){
        return s == null ? null : s.trim().toUpperCase();
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Car other)) return false;
        return Objects.equals(norm(this.numberplate), norm(other.numberplate));
    }

    @Override
    public int hashCode(){
        return Objects.hash(norm(this.numberplate));
    }
}
