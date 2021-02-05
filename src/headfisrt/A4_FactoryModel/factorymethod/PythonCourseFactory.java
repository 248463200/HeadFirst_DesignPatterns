package headfisrt.A4_FactoryModel.factorymethod;


import headfisrt.A4_FactoryModel.ICourse;
import headfisrt.A4_FactoryModel.PythonCourse;

public class PythonCourseFactory implements ICourseFactory {

    public ICourse create() {
        return new PythonCourse();
    }
}
