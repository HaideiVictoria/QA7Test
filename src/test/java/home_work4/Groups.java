package home_work4;

import org.testng.annotations.Test;

public class Groups {
    @Test(groups = {"first"})
    public void one() {
        assert true;
    }

    @Test(groups = {"second"})
    public void two() {
        assert true;
    }

    @Test(groups = {"first"} )
    public void three() {
        assert true;
    }

    @Test(groups ={"second"})
    public void four() {
        assert true;
    }

    @Test(groups = {"first"})
    public void five() {
        assert true;
    }

    @Test(groups = {"second"})
    public void six() {
        assert true;
    }

    @Test(groups = {"first"})
    public void seven() {
        assert true;
}}
