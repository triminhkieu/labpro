/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author Admin
 */
public class Transcript {
    public Student st;
    public Subject sub;
    public double labMark;
    public double testMark;
    public double finalMark;

    public Transcript() {
    }
    
    public Transcript(Student st, Subject sub, double labMark, double testMark, double finalMark) {
        this.st = st;
        this.sub = sub;
        this.labMark = labMark;
        this.testMark = testMark;
        this.finalMark = finalMark;
    }
    
    public double average() {
        double total = 0.3 * labMark + 0.3 * testMark + 0.4 * finalMark;
        return total;
    }

    public Transcript(Student st, Subject sub) {
        this.st = st;
        this.sub = sub;
    }

    @Override
    public boolean equals(Object obj) {
        Transcript t = (Transcript) obj;
        boolean bl = this.st == t.st && this.sub == t.sub;
        return bl;
    }
    
    
}
