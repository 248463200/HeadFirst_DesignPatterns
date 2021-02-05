package headfisrt.A4_FactoryModel.factorymethod;


import headfisrt.A4_FactoryModel.ICourse;

public class FactoryMethodTest {

    public static void main(String[] args) {

        ICourseFactory factory = new PythonCourseFactory();
        ICourse course = factory.create();
        course.record();

        factory = new JavaCourseFactory();
        course = factory.create();
        course.record();

    }

}
