package ImageIO;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

/**
 * openCV�в��ܳ��������ַ���������Ƭ���ܳ��֣�����dll���ܳ��֡������������²ۣ�
 * 
 * @author ��С��
 *
 */
public class Main {

	public static  Mat run(Mat img) {
		// ���ȥ����/��
		String xmlPath = "F:\\OpenVC\\opencv\\build\\etc\\haarcascades\\haarcascade_frontalface_default.xml";
		CascadeClassifier faceDetector = new CascadeClassifier();// ����������
		faceDetector.load(xmlPath);// ���ؼ���������
//		Mat image = Imgcodecs.imread("G:\\ii.jpg");// Mat��Ķ������ڱ�ʾһ����ά�ȵĵ�ͨ�����߶�ͨ����������
		MatOfRect faceDetections = new MatOfRect();//����������
		try {
		faceDetector.detectMultiScale(img, faceDetections);//�����������þ��󱣴�
		}
		catch (Exception e) {
			System.out.println(""+faceDetections);
			System.out.println("��ȡ�ļ��������");
		}
		for (Rect rect : faceDetections.toArray()) {
			Imgproc.rectangle(img, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
					new Scalar(0, 255, 0));//������ɫ
		}
//		String filename = "face_ta.png";
//		Imgcodecs.imwrite(filename, img);
//		System.out.println(filename);
		return img;
	}

}
