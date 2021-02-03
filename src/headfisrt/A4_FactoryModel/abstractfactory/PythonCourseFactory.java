package headfisrt.A4_FactoryModel.abstractfactory;

/**
 * Created by Tom.
 */
public class PythonCourseFactory implements CourseFactory {

    public INote createNote() {
        return new PythonNote();
    }


    public IVideo createVideo() {
        return new PythonVideo();
    }
}
