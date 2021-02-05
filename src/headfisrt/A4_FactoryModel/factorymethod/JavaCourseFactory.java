package headfisrt.A4_FactoryModel.factorymethod;

import headfisrt.A4_FactoryModel.ICourse;
import headfisrt.A4_FactoryModel.JavaCourse;

public class JavaCourseFactory implements ICourseFactory {
    public ICourse create() {
        return new JavaCourse();
    }
}
