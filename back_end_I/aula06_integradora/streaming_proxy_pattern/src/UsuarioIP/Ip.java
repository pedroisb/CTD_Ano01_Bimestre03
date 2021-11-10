package UsuarioIP;

import java.util.ArrayList;
import java.util.List;

public class Ip {

    private List<Integer> numIp;

    public Ip(int num01, int num02, int num03, int num04) {
        this.numIp = new ArrayList<>();
        numIp.add(num01);
        numIp.add(num02);
        numIp.add(num03);
        numIp.add(num04);
    }

    public List<Integer> getNumIp() {
        return numIp;
    }

    public void setNumIp(List<Integer> numIp) {
        this.numIp = numIp;
    }

    @Override
    public String toString() {
        return "Usuario.Ip{" +
                "numIp=" +
                numIp.indexOf(0) +"."+
                numIp.indexOf(1) +"."+
                numIp.indexOf(2) +"."+
                numIp.indexOf(3) +
                '}';
    }
}
