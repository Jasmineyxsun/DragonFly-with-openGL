/**
 * @author Jeffrey Finkelstein <jeffrey.finkelstein@gmail.com>
 * @author Zezhou Sun <micou@bu.edu>
 * @since Spring 2011
 */

import java.util.HashMap;
import java.util.Map;

public class TestCases extends CyclicIterator<Map<String, Configuration>> {

//	public static String INDEX_PALM_NAME = "index palm";
//	public static String INDEX_MIDDLE_NAME = "index middle";
//	public static String INDEX_DISTAL_NAME = "index distal";
//	public static String RING_PALM_NAME = "ring palm";
//	public static String RING_MIDDLE_NAME = "ring middle";
//	public static String RING_DISTAL_NAME = "ring distal";
//	public static String MIDDLE_PALM_NAME = "middle palm";
//	public static String MIDDLE_MIDDLE_NAME = "middle middle";
//	public static String MIDDLE_DISTAL_NAME = "middle distal";
//	public static String PINKY_PALM_NAME = "pinky palm";
//	public static String PINKY_MIDDLE_NAME = "pinky middle";
//	public static String PINKY_DISTAL_NAME = "pinky distal";
//	public static String THUMB_PALM_NAME = "thumb palm";
//	public static String THUMB_MIDDLE_NAME = "thumb middle";
//	public static String THUMB_DISTAL_NAME = "thumb distal";
//	public static String HAND_NAME = "hand";
//	public static String FOREARM_NAME = "forearm";
//	public static String UPPER_ARM_NAME = "upper arm";
	
	public static final String Femur1LeftName = "femur 1 left";
	public static final String Femur1RightName = "femur 1 right";
	public static final String Femur2LeftName = "femur 2 left";
	public static final String Femur2RightName = "femur 2 right";
	public static final String Femur3LeftName = "femur 3 left";
	public static final String Femur3RightName = "femur 3 right";
	public static final String Tibia1LeftName = "tibia 1 left";
	public static final String Tibia1RightName = "tibia 1 right";
	public static final String Tibia2LeftName = "tibia 2 left";
	public static final String Tibia2RightName = "tibia 2 right";
	public static final String Tibia3LeftName = "tibia 3 left";
	public static final String Tibia3RightName = "tibia 3 right";
	
	public static final String Tarsus1LeftName = "tarsus 1 left";
	public static final String Tarsus1RightName = "tarsus 1 right";
	public static final String Tarsus2LeftName = "tarsus 2 left";
	public static final String Tarsus2RightName = "tarsus 2 right";
	public static final String Tarsus3LeftName = "tarsus 3 left";
	public static final String Tarsus3RightName = "tarsus 3 right";
	
	public static final String ForeWingLeftName = "fore wing left";
	public static final String ForeWingRightName = "fore wing right";
	public static final String HindWingLeftName = "hind wing left";
	public static final String HindWingRightName = "hind wing right";
	
	public static final String HeadName = "head";
	public static final String BodyName = "body name";
	public static final String TailName = "tail name";

	Map<String, Configuration> stop() {
		return this.stop;
	}

	private final Map<String, Configuration> stop;

	@SuppressWarnings("unchecked")
	TestCases() {
		this.stop = new HashMap<String, Configuration>();
		final Map<String, Configuration> watch = new HashMap<String, Configuration>();
		final Map<String, Configuration> specimen = new HashMap<String, Configuration>();
		final Map<String, Configuration> shaka = new HashMap<String, Configuration>();
		final Map<String, Configuration> spread = new HashMap<String, Configuration>();
		final Map<String, Configuration> fly = new HashMap<String, Configuration>();

		super.add(stop, watch, specimen, shaka, spread, fly);

		stop.put(BodyName, new BaseConfiguration(0, 0, 0));
		watch.put(BodyName, new BaseConfiguration(0, -45, -45));
		specimen.put(BodyName, new BaseConfiguration(-70, 0, 90));
		shaka.put(BodyName, new BaseConfiguration(0, -45, -45));
		spread.put(BodyName, new BaseConfiguration(0, 0, -90));
		fly.put(BodyName, new BaseConfiguration(0, 0, 15));

		stop.put(HeadName, new BaseConfiguration(0, 0, 0));
		watch.put(HeadName, new BaseConfiguration(0, 0, 0));
		specimen.put(HeadName, new BaseConfiguration(0, 0, 0));
		shaka.put(HeadName, new BaseConfiguration(0, 0, 0));
		spread.put(HeadName, new BaseConfiguration(0, 0, 0));
		fly.put(HeadName, new BaseConfiguration(0, 0, 0));

		stop.put(TailName, new BaseConfiguration(0, 0, 0));
		watch.put(TailName, new BaseConfiguration(0, 0, 0));
		specimen.put(TailName, new BaseConfiguration(0, 0, 0));
		shaka.put(TailName, new BaseConfiguration(0, 0, 0));
		spread.put(TailName, new BaseConfiguration(0, 0, 0));
		fly.put(TailName, new BaseConfiguration(0, 0, 0));

		// the stop test case
		stop.put(Femur1LeftName, new BaseConfiguration(100, 150, -150));
		stop.put(Femur1RightName, new BaseConfiguration(100, -150, -150));
		stop.put(Femur2LeftName, new BaseConfiguration(100, 150, -150));
		stop.put(Femur2RightName, new BaseConfiguration(100, -150, -150));
		stop.put(Femur3LeftName, new BaseConfiguration(100, 150, -150));
		stop.put(Femur3RightName, new BaseConfiguration(100, -150, -150));
		stop.put(Tibia1LeftName, new BaseConfiguration(100, 150, -150));
		stop.put(Tibia1RightName, new BaseConfiguration(100, 150, -150));
		stop.put(Tibia2LeftName, new BaseConfiguration(100, 150, -150));
		stop.put(Tibia2RightName, new BaseConfiguration(100, 150, -150));
		stop.put(Tibia3LeftName, new BaseConfiguration(100, 150, -150));
		stop.put(Tibia3RightName, new BaseConfiguration(100, 150, -150));
		stop.put(Tarsus1LeftName, new BaseConfiguration(100, -90, -150));
		stop.put(Tarsus1RightName, new BaseConfiguration(100, -360, -150));
		stop.put(Tarsus2LeftName, new BaseConfiguration(100, -90, -150));
		stop.put(Tarsus2RightName, new BaseConfiguration(100, -360, -150));
		stop.put(Tarsus3LeftName, new BaseConfiguration(100, -90, -150));
		stop.put(Tarsus3RightName, new BaseConfiguration(100, -360, -150));
		stop.put(ForeWingLeftName, new BaseConfiguration(0, 0, 0));
		stop.put(ForeWingRightName, new BaseConfiguration(0, 0, 0));
		stop.put(HindWingLeftName, new BaseConfiguration(0, 0, 0));
		stop.put(HindWingRightName, new BaseConfiguration(0, 0, 0));

		// the watch sign test case
		watch.put(Femur1LeftName, new BaseConfiguration(130, 150, -150));
		watch.put(Femur1RightName, new BaseConfiguration(130, -150, 150));
		watch.put(Femur2LeftName, new BaseConfiguration(130, 150, -150));
		watch.put(Femur2RightName, new BaseConfiguration(130, -150, 150));
		watch.put(Femur3LeftName, new BaseConfiguration(130, 150, -150));
		watch.put(Femur3RightName, new BaseConfiguration(130, -150, 150));
		watch.put(Tibia1LeftName, new BaseConfiguration(190, 180, -150));
		watch.put(Tibia1RightName, new BaseConfiguration(190, 180, -150));
		watch.put(Tibia2LeftName, new BaseConfiguration(190, 180, -150));
		watch.put(Tibia2RightName, new BaseConfiguration(190, 180, -150));
		watch.put(Tibia3LeftName, new BaseConfiguration(190, 180, -150));
		watch.put(Tibia3RightName, new BaseConfiguration(190, 180, -150));
		watch.put(Tarsus1LeftName, new BaseConfiguration(0, 0, 0));
		watch.put(Tarsus1RightName, new BaseConfiguration(0, 0, 0));
		watch.put(Tarsus2LeftName, new BaseConfiguration(0, 0, 0));
		watch.put(Tarsus2RightName, new BaseConfiguration(0, 0, 0));
		watch.put(Tarsus3LeftName, new BaseConfiguration(0, 0, 0));
		watch.put(Tarsus3RightName, new BaseConfiguration(0, 0, 0));
		watch.put(ForeWingLeftName, new BaseConfiguration(0, 0, 0));
		watch.put(ForeWingRightName, new BaseConfiguration(0, 0, 0));
		watch.put(HindWingLeftName, new BaseConfiguration(0, 0, 0));
		watch.put(HindWingRightName, new BaseConfiguration(0, 0, 0));

		// the specimen test case
		specimen.put(Femur1LeftName, new BaseConfiguration(100, 150, -150));
		specimen.put(Femur1RightName, new BaseConfiguration(100, -150, -150));
		specimen.put(Femur2LeftName, new BaseConfiguration(100, 150, -150));
		specimen.put(Femur2RightName, new BaseConfiguration(100, -150, -150));
		specimen.put(Femur3LeftName, new BaseConfiguration(100, 150, -150));
		specimen.put(Femur3RightName, new BaseConfiguration(100, -150, -150));
		specimen.put(Tibia1LeftName, new BaseConfiguration(100, 150, -150));
		specimen.put(Tibia1RightName, new BaseConfiguration(100, 150, -150));
		specimen.put(Tibia2LeftName, new BaseConfiguration(100, 150, -150));
		specimen.put(Tibia2RightName, new BaseConfiguration(100, 150, -150));
		specimen.put(Tibia3LeftName, new BaseConfiguration(100, 150, -150));
		specimen.put(Tibia3RightName, new BaseConfiguration(100, 150, -150));
		specimen.put(Tarsus1LeftName, new BaseConfiguration(100, -90, -150));
		specimen.put(Tarsus1RightName, new BaseConfiguration(100, -360, -150));
		specimen.put(Tarsus2LeftName, new BaseConfiguration(100, -90, -150));
		specimen.put(Tarsus2RightName, new BaseConfiguration(100, -360, -150));
		specimen.put(Tarsus3LeftName, new BaseConfiguration(100, -90, -150));
		specimen.put(Tarsus3RightName, new BaseConfiguration(100, -360, -150));
		specimen.put(ForeWingLeftName, new BaseConfiguration(0, 0, 0));
		specimen.put(ForeWingRightName, new BaseConfiguration(0, 0, 0));
		specimen.put(HindWingLeftName, new BaseConfiguration(0, 0, 0));
		specimen.put(HindWingRightName, new BaseConfiguration(0, 0, 0));
		
		// the shaka test case
		shaka.put(Femur1LeftName, new BaseConfiguration(50, 150, -150));
		shaka.put(Femur1RightName, new BaseConfiguration(50, -150, 150));
		shaka.put(Femur2LeftName, new BaseConfiguration(50, 150, -150));
		shaka.put(Femur2RightName, new BaseConfiguration(50, -150, 150));
		shaka.put(Femur3LeftName, new BaseConfiguration(50, 150, -150));
		shaka.put(Femur3RightName, new BaseConfiguration(50, -150, 150));
		shaka.put(Tibia1LeftName, new BaseConfiguration(100, 180, -150));
		shaka.put(Tibia1RightName, new BaseConfiguration(100, 180, -150));
		shaka.put(Tibia2LeftName, new BaseConfiguration(100, 180, -150));
		shaka.put(Tibia2RightName, new BaseConfiguration(100, 180, -150));
		shaka.put(Tibia3LeftName, new BaseConfiguration(100, 180, -150));
		shaka.put(Tarsus1LeftName, new BaseConfiguration(-30, -30, -30));
		shaka.put(Tarsus1RightName, new BaseConfiguration(-30, -30, -30));
		shaka.put(Tarsus2LeftName, new BaseConfiguration(-30, -30, -30));
		shaka.put(Tarsus2RightName, new BaseConfiguration(-30, -30, -30));
		shaka.put(Tarsus3LeftName, new BaseConfiguration(-30, -30, -30));
		shaka.put(Tarsus3RightName, new BaseConfiguration(-30, -30, -30));
		shaka.put(ForeWingLeftName, new BaseConfiguration(0, 0, 0));
		shaka.put(ForeWingRightName, new BaseConfiguration(0, 0, 0));
		shaka.put(HindWingLeftName, new BaseConfiguration(0, 0, 0));
		shaka.put(HindWingRightName, new BaseConfiguration(0, 0, 0));


		// the spread test case
		spread.put(Femur1LeftName, new BaseConfiguration(100, 90, 0));
		spread.put(Femur1RightName, new BaseConfiguration(100, -90, 0));
		spread.put(Femur2LeftName, new BaseConfiguration(100, 90, 0));
		spread.put(Femur2RightName, new BaseConfiguration(100, -90, 0));
		spread.put(Femur3LeftName, new BaseConfiguration(100, 90, 0));
		spread.put(Femur3RightName, new BaseConfiguration(100, -90, 0));
		spread.put(Tibia1LeftName, new BaseConfiguration(0, 0, 0));
		spread.put(Tibia1RightName, new BaseConfiguration(0, 0, 0));
		spread.put(Tibia2LeftName, new BaseConfiguration(0, 0, 0));
		spread.put(Tibia2RightName, new BaseConfiguration(0, 0, 0));
		spread.put(Tibia3LeftName, new BaseConfiguration(0, 0, 0));
		spread.put(Tibia3RightName, new BaseConfiguration(0, 0, 0));
		spread.put(Tarsus1LeftName, new BaseConfiguration(0, 0, 0));
		spread.put(Tarsus1RightName, new BaseConfiguration(0, 0, 0));
		spread.put(Tarsus2LeftName, new BaseConfiguration(0, 0, 0));
		spread.put(Tarsus2RightName, new BaseConfiguration(0, 0, 0));
		spread.put(Tarsus3LeftName, new BaseConfiguration(0, 0, 0));
		spread.put(Tarsus3RightName, new BaseConfiguration(0, 0, 0));
		spread.put(ForeWingLeftName, new BaseConfiguration(0, 0, 0));
		spread.put(ForeWingRightName, new BaseConfiguration(0, 0, 0));
		spread.put(HindWingLeftName, new BaseConfiguration(0, 0, 0));
		spread.put(HindWingRightName, new BaseConfiguration(0, 0, 0));


		// the fly test case
		fly.put(Femur1LeftName, new BaseConfiguration(100, 150, -150));
		fly.put(Femur1RightName, new BaseConfiguration(100, -150, -150));
		fly.put(Femur2LeftName, new BaseConfiguration(100, 150, -150));
		fly.put(Femur2RightName, new BaseConfiguration(100, -150, -150));
		fly.put(Femur3LeftName, new BaseConfiguration(100, 150, -150));
		fly.put(Femur3RightName, new BaseConfiguration(100, -150, -150));
		fly.put(Tibia1LeftName, new BaseConfiguration(100, 150, -150));
		fly.put(Tibia1RightName, new BaseConfiguration(100, 150, -150));
		fly.put(Tibia2LeftName, new BaseConfiguration(100, 150, -150));
		fly.put(Tibia2RightName, new BaseConfiguration(100, 150, -150));
		fly.put(Tibia3LeftName, new BaseConfiguration(100, 150, -150));
		fly.put(Tibia3RightName, new BaseConfiguration(100, 150, -150));
		fly.put(Tarsus1LeftName, new BaseConfiguration(100, -90, -150));
		fly.put(Tarsus1RightName, new BaseConfiguration(100, -360, -150));
		fly.put(Tarsus2LeftName, new BaseConfiguration(100, -90, -150));
		fly.put(Tarsus2RightName, new BaseConfiguration(100, -360, -150));
		fly.put(Tarsus3LeftName, new BaseConfiguration(100, -90, -150));
		fly.put(Tarsus3RightName, new BaseConfiguration(100, -360, -150));
		fly.put(ForeWingLeftName, new BaseConfiguration(0, 0, -30));
		fly.put(ForeWingRightName, new BaseConfiguration(0, 0, 30));
		fly.put(HindWingLeftName, new BaseConfiguration(0, 0, -30));
		fly.put(HindWingRightName, new BaseConfiguration(0, 0, 30));

	}
}
