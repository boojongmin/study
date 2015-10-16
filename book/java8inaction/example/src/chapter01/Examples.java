package chapter01;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.List;

import static chapter01.FilteringApples.filterApples;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class Examples {

    @Test
    public void test_1_2_1(){
        File[] hiddenFiles = new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isHidden();
            }
        });
        Assert.assertThat("before java 8 : hidden file length is one that is '.hiddenFile' ", 1, equalTo( hiddenFiles.length));

        hiddenFiles = new File(".").listFiles(File::isHidden);
        Assert.assertThat("after java 8 : hidden file length is one that is '.hiddenFile' ", 1, equalTo( hiddenFiles.length));
    }



    @Test
    public void test_1_2_2(){
        List<Apple> inventory = Arrays.asList(new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

                             //why static?
        List<Apple> apples = filterApples(inventory, FilteringApples::isGreenApple);
        Assert.assertThat("green apple's count is 2.", 2, equalTo(apples.size()));

        apples = filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
        Assert.assertThat("lambda : green apple's count is 2.", 2, equalTo(apples.size()));
    }

    @Test
    public void test_1_2_2_lambda(){
        List<Apple> inventory = Arrays.asList(new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

                             //why static?
        List<Apple> apples = filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
        Assert.assertThat("lambda : green apple's count is 2.", 2, equalTo(apples.size()));
    }

    

}




