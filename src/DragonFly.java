import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.media.opengl.GL2;

import com.jogamp.opengl.util.gl2.GLUT;

public class DragonFly extends Component implements Animate, Selection {
	/** The OpenGL utility toolkit object. */
	private final GLUT glut = new GLUT();
	
	/* ** The head to be modeled. */
	private final Component head;
	/** The body to be modeled. */
	private final Component body;
	/** The tail to be modeled. */
	private final Component tail;
	/** The wings on the body to be modeled. */
	private final Wings[] wings;
	/** The legs on the body to be modeled. */
	private final Legs[] legs;
	/** The set of all components. */
	private final List<Component> components;
	/** The set of components which are currently selected for rotation. */
	private final Set<Component> selectedComponents = new HashSet<Component>(25);
	/** The color for components which are selected for rotation. */
	public static final FloatColor ACTIVE_COLOR = FloatColor.RED;
  	/** The color for components which are not selected for rotation. */
	public static final FloatColor INACTIVE_COLOR = FloatColor.GREEN;
	
	
	/** The radius of the components which comprise the head. */
	public static final double HeadRadius = 0.18;
	/** The height of the distal joint on head and body. */
	public static final double HeadBodyJointHeight = - 0.3;
	
	/** The radius of the components which comprise the body. */
	public static final double BodyRadius = 0.18;
	/** The height of the body. */
	public static final double BodyHeight = 1.8 * BodyRadius;
	
	/** The radius of the components which comprise the body. */
	public static final double BodyTailJointHeight = 0.3;
	/** The radius of the components which comprise the tail. */
	public static final double TailRadius = 0.1;
	/** The height of the tail. */
	public static final double TailHeight = 2;
	
	/** The radius of the components which comprise the wing. */
	public static final double WingRadius = 0.4;
	/** The height of the distal joint on wings and body. */
	public static final double WingBodyJointHeight = 0.1;

	/** The radius of each joint which comprises the legs. */
	public static final double LegRadius = 0.025;
	/** The height of the femur joint on each of the leg. */
	public static final double FemurJointLegHeight = 0.25;
	/** The height of the tibia joint on each of the leg. */
	public static final double TibiaJointLegHeight = 0.25;
	/** The height of the tarsus joint on each of the leg. */
	public static final double TarsusJointLegHeight = 0.1;
	
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
	
	
  	private Component mapNum2Component(int componentNum) {
  		switch(componentNum) {
  			case  0: return this.head;
			case  1: return this.body;
			case  2: return this.tail;
			//leg 1 left front leg
			case  3: return this.legs[0].femurJoint();
			case  4: return this.legs[0].tibiaJoint();
			case  5: return this.legs[0].tarsusJoint();
			
			//leg 2 left middle leg
			case  6: return this.legs[1].femurJoint();
			case  7: return this.legs[1].tibiaJoint();
			case  8: return this.legs[1].tarsusJoint();
			
			//leg 3 left hind leg
			case  9: return this.legs[2].femurJoint();
			case 10: return this.legs[2].tibiaJoint();
			case 11: return this.legs[2].tarsusJoint();
			
			//leg 1 right front leg
			case 12: return this.legs[3].femurJoint();
			case 13: return this.legs[3].tibiaJoint();
			case 14: return this.legs[3].tarsusJoint();
			
			//leg2 right middle leg
			case 15: return this.legs[4].femurJoint();
			case 16: return this.legs[4].tibiaJoint();
			case 17: return this.legs[4].tarsusJoint();
			
			//leg3 right hind leg
			case 18: return this.legs[5].femurJoint();
			case 19: return this.legs[5].tibiaJoint();
			case 20: return this.legs[5].tarsusJoint();
			
			//wing 0: left front wing
			case 21: return this.wings[0].bodyJoint();
			//wing 1: right front wing
			case 22: return this.wings[1].bodyJoint();
			//wing 2: left hind wing
			case 23: return this.wings[2].bodyJoint();
			//wing 3: right hind wing 
			case 24: return this.wings[3].bodyJoint();
			
			default: throw new IllegalArgumentException("componentNum over index");
  		}
  	}
  	
  	private Component mapName2Component(String componentName) {
  		switch(componentName) {
	  		case  HeadName: return this.head;
			case  BodyName: return this.body;
			case  TailName: return this.tail;

			
			case  Femur1LeftName: return this.legs[0].femurJoint();
			case  Femur1RightName: return this.legs[1].femurJoint();
			case  Femur2LeftName: return this.legs[2].femurJoint();
			case  Femur2RightName: return this.legs[3].femurJoint();
			case  Femur3LeftName: return this.legs[4].femurJoint();
			case  Femur3RightName: return this.legs[5].femurJoint();
			
			case  Tibia1LeftName: return this.legs[0].tibiaJoint();
			case  Tibia1RightName: return this.legs[1].tibiaJoint();
			case  Tibia2LeftName: return this.legs[2].tibiaJoint();
			case  Tibia2RightName: return this.legs[3].tibiaJoint();
			case  Tibia3LeftName: return this.legs[4].tibiaJoint();
			case  Tibia3RightName: return this.legs[5].tibiaJoint();
			
			case  Tarsus1LeftName: return this.legs[0].tarsusJoint();
			case  Tarsus1RightName: return this.legs[1].tarsusJoint();
			case  Tarsus2LeftName: return this.legs[2].tarsusJoint();
			case  Tarsus2RightName: return this.legs[3].tarsusJoint();
			case  Tarsus3LeftName: return this.legs[4].tarsusJoint();
			case  Tarsus3RightName: return this.legs[5].tarsusJoint();
			
			case ForeWingLeftName: return this.wings[0].bodyJoint();
			case ForeWingRightName: return this.wings[1].bodyJoint();
			case HindWingLeftName: return this.wings[2].bodyJoint();
			case HindWingRightName: return this.wings[3].bodyJoint();	

			default: throw new IllegalArgumentException("componentName doesn't exist");
  		}
  	}

	@Override
	public void toggleSelection(int componentNum) {
  		if ( 0 <= componentNum && componentNum <= 25) {
  			Component component = mapNum2Component(componentNum);
  			if ( this.selectedComponents.contains(component) ) {
  				this.selectedComponents.remove(component);
  				component.setColor(INACTIVE_COLOR);
  			}
  			else {
  		      this.selectedComponents.add(component);
  		      component.setColor(ACTIVE_COLOR);
  		    }
		}
		
	}

	@Override
	public void changeSelected(Configuration configuration) {
  		for(Component c: this.selectedComponents) {
  			c.changeConfiguration(configuration);
  		}
		
	}

	@Override
	public void setModelStates(ArrayList<Configuration> config_list) {
  		for (int i = 0; i < config_list.size(); i++) {
  			if ( 0 <= i && i <= 25) {
  				mapNum2Component(i).setAngles(config_list.get(i));
  			}
  		}
		
	}
	
  	public void setModelStates(final Map<String, Configuration> state) {
  		for (Map.Entry<String, Configuration> entry: state.entrySet()) {
  			this.mapName2Component(entry.getKey()).setAngles(entry.getValue());
  		}
  	}
  	
  	/**
     * Prints the joints on the specified PrintStream.
     * 
     * @param printStream
     *          The stream on which to print each of the components.
     */
    public void printJoints(final PrintStream printStream) {
      for (final Component component : this.components) {
        printStream.println(component);
      }
    }
	
  	
	public DragonFly(final Point3D position,String name) {
		super(position, name);
		//all the tarsus joints
	    final Component tarsus1Left = new Component(new Point3D(0, 0,
	    		TibiaJointLegHeight), new RoundedCylinder(LegRadius,
		        TarsusJointLegHeight, this.glut), Tarsus1LeftName);
	    final Component tarsus1Right = new Component(new Point3D(0, 0,
	    		TibiaJointLegHeight), new RoundedCylinder(LegRadius,
		        TarsusJointLegHeight, this.glut), Tarsus1RightName);
	    final Component tarsus2Left = new Component(new Point3D(0, 0,
	    		TibiaJointLegHeight), new RoundedCylinder(LegRadius,
		        TarsusJointLegHeight, this.glut), Tarsus2LeftName);
	    final Component tarsus2Right = new Component(new Point3D(0, 0,
	    		TibiaJointLegHeight), new RoundedCylinder(LegRadius,
		        TarsusJointLegHeight, this.glut), Tarsus2RightName);
	    final Component tarsus3Left = new Component(new Point3D(0, 0,
	    		TibiaJointLegHeight), new RoundedCylinder(LegRadius,
		        TarsusJointLegHeight, this.glut), Tarsus3LeftName);
	    final Component tarsus3Right = new Component(new Point3D(0, 0,
	    		TibiaJointLegHeight), new RoundedCylinder(LegRadius,
		        TarsusJointLegHeight, this.glut), Tarsus3RightName);

	    //all the tibia joint
	    final Component tibia1Left = new Component(new Point3D(0, 0,
	    		FemurJointLegHeight), new RoundedCylinder(LegRadius,
		        TibiaJointLegHeight, this.glut), Tibia1LeftName);
	    final Component tibia1Right = new Component(new Point3D(0, 0,
	    		FemurJointLegHeight), new RoundedCylinder(LegRadius,
		        TibiaJointLegHeight, this.glut), Tibia1RightName);
	    final Component tibia2Left = new Component(new Point3D(0, 0,
	    		FemurJointLegHeight), new RoundedCylinder(LegRadius,
		        TibiaJointLegHeight, this.glut), Tibia2LeftName);
	    final Component tibia2Right = new Component(new Point3D(0, 0,
	    		FemurJointLegHeight), new RoundedCylinder(LegRadius,
		        TibiaJointLegHeight, this.glut), Tibia2RightName);
	    final Component tibia3Left = new Component(new Point3D(0, 0,
	    		FemurJointLegHeight), new RoundedCylinder(LegRadius,
		        TibiaJointLegHeight, this.glut), Tibia3LeftName);
	    final Component tibia3Right = new Component(new Point3D(0, 0,
	    		FemurJointLegHeight), new RoundedCylinder(LegRadius,
		        TibiaJointLegHeight, this.glut), Tibia3RightName);
	    
	    //all the femur joint
	    final Component femur1Left = new Component(new Point3D(0, 0.1,
	    		0.05), new RoundedCylinder(LegRadius,
		       FemurJointLegHeight, this.glut), Femur1LeftName);
	    final Component femur1Right = new Component(new Point3D(0, 0.1,
	    		0.05), new RoundedCylinder(LegRadius,
		        FemurJointLegHeight, this.glut), Femur1RightName);
	    final Component femur2Left = new Component(new Point3D(0, 0.1,
	    		0.2), new RoundedCylinder(LegRadius,
		       FemurJointLegHeight, this.glut), Femur2LeftName);
	    final Component femur2Right = new Component(new Point3D(0, 0.1,
	    		0.2), new RoundedCylinder(LegRadius,
		        FemurJointLegHeight, this.glut), Femur2RightName);
	    final Component femur3Left = new Component(new Point3D(0, 0.1,
	    		0.4), new RoundedCylinder(LegRadius,
		       FemurJointLegHeight, this.glut), Femur3LeftName);
	    final Component femur3Right = new Component(new Point3D(0, 0.1,
	    		0.4), new RoundedCylinder(LegRadius,
		        FemurJointLegHeight, this.glut), Femur3RightName);
	    
	    //all the wings joint
	    final Component foreWingLeft = new Component(new Point3D(-0.25,0,
	    		-1), new LeftWing(WingRadius, this.glut), ForeWingLeftName);
	    final Component foreWingRight = new Component(new Point3D(0.25,0,
	    		1.5), new RightWing(WingRadius, this.glut), ForeWingRightName);
	    final Component hindWingLeft = new Component(new Point3D(-0.25, 0,
	    		-0.5), new LeftWing(WingRadius, this.glut), HindWingLeftName);
	    final Component hindWingRight = new Component(new Point3D(0.25, 0,
	    		 1), new RightWing(WingRadius,this.glut), HindWingRightName);
//	    final Component foreWingLeft = new Component(new Point3D(0.75, 0.85,
//	    		-0.25), new Wing(WingRadius, this.glut), ForeWingLeftName);
//	    final Component foreWingRight = new Component(new Point3D(-0.75, 0.85,
//	    		-0.25), new Wing(WingRadius, this.glut), ForeWingRightName);
//	    final Component hindWingLeft = new Component(new Point3D(0.75, 0.85,
//	    		0.5), new Wing(WingRadius, this.glut), HindWingLeftName);
//	    final Component hindWingRight = new Component(new Point3D(-0.75, 0.85,
//	    		0.5), new Wing(WingRadius,this.glut), HindWingRightName);
	    
	    //put together all the legs for easier selection by keyboard input
	    this.legs = new Legs[] {new Legs(femur1Left, tibia1Left, tarsus1Left),
	    		new Legs(femur1Right, tibia1Right, tarsus1Right),
	    		new Legs(femur2Left, tibia2Left, tarsus2Left),
	    		new Legs(femur2Right, tibia2Right, tarsus2Right),
	    		new Legs(femur3Left, tibia3Left, tarsus3Left),
	    		new Legs(femur3Right, tibia3Right, tarsus3Right)
	    		};
	    
	    //put together all the wings for easier selection by keyboard input
	    this.wings = new Wings[] {new Wings(foreWingLeft),
	    		new Wings(foreWingRight),
	    		new Wings(hindWingLeft),
	    		new Wings(hindWingRight),
	    }; 
	    // the head
	    this.head = new Component(new Point3D(0, 0, HeadBodyJointHeight), new Head(
	    		HeadRadius, this.glut), HeadName);
	    // the body
	    this.body = new Component(new Point3D(0, 0, -2.5), new Body(
	    		BodyRadius, this.glut), BodyName);    
	    // the tail
	    this.tail = new Component(new Point3D(0, 0, BodyHeight), new RoundedCylinder(
	    		TailRadius, TailHeight, this.glut), TailName);   
	    
	    this.addChild(this.body);
	    this.body.addChildren(this.head, this.tail,foreWingLeft, foreWingRight, hindWingLeft, hindWingRight);
	    this.body.addChildren(femur1Left, femur1Right,femur2Left, femur2Right,femur3Left, femur3Right);
	   
	    femur1Left.addChild(tibia1Left);
	    femur1Right.addChild(tibia1Right);
	    femur2Left.addChild(tibia2Left);
	    femur2Right.addChild(tibia2Right);
	    femur3Left.addChild(tibia3Left);
	    femur3Right.addChild(tibia3Right);
	    
	    tibia1Left.addChild(tarsus1Left);
	    tibia1Right.addChild(tarsus1Right);
	    tibia2Left.addChild(tarsus2Left);
	    tibia2Right.addChild(tarsus2Right);
	    tibia3Left.addChild(tarsus3Left);
	    tibia3Right.addChild(tarsus3Right);
	    
	    // turn the whole dragon fly
	    this.rotate(Axis.X, -110);
	    this.rotate(Axis.Y, 110);
	    this.rotate(Axis.Z, -60);
	    
	    //rotate the leg parts to be in right order
	    femur1Left.rotate(Axis.X, 100);
	    femur1Left.rotate(Axis.Y, 150);
	    femur1Left.rotate(Axis.Z, -150);
	    tibia1Left.rotate(Axis.X, 100);
	    tibia1Left.rotate(Axis.Y, 150);
	    tibia1Left.rotate(Axis.Z, -150);
	    tarsus1Left.rotate(Axis.X, 100);
	    tarsus1Left.rotate(Axis.Y, -90);
	    tarsus1Left.rotate(Axis.Z, -150);
	    
	    femur1Right.rotate(Axis.X, 100);
	    femur1Right.rotate(Axis.Y, -150);
	    femur1Right.rotate(Axis.Z, -150);
	    tibia1Right.rotate(Axis.X, 100);
	    tibia1Right.rotate(Axis.Y, 150);
	    tibia1Right.rotate(Axis.Z, -150);
	    tarsus1Right.rotate(Axis.X, 100);
	    tarsus1Right.rotate(Axis.Y, -360);
	    tarsus1Right.rotate(Axis.Z, -150);
	    
	    femur2Left.rotate(Axis.X, 100);
	    femur2Left.rotate(Axis.Y, 150);
	    femur2Left.rotate(Axis.Z, -150);
	    tibia2Left.rotate(Axis.X, 100);
	    tibia2Left.rotate(Axis.Y, 150);
	    tibia2Left.rotate(Axis.Z, -150);
	    tarsus2Left.rotate(Axis.X, 100);
	    tarsus2Left.rotate(Axis.Y, -90);
	    tarsus2Left.rotate(Axis.Z, -150);
	    
	    femur2Right.rotate(Axis.X, 100);
	    femur2Right.rotate(Axis.Y, -150);
	    femur2Right.rotate(Axis.Z, -150);
	    tibia2Right.rotate(Axis.X, 100);
	    tibia2Right.rotate(Axis.Y, 150);
	    tibia2Right.rotate(Axis.Z, -150);
	    tarsus2Right.rotate(Axis.X, 100);
	    tarsus2Right.rotate(Axis.Y, -360);
	    tarsus2Right.rotate(Axis.Z, -150);
	    
	    femur3Left.rotate(Axis.X, 100);
	    femur3Left.rotate(Axis.Y, 150);
	    femur3Left.rotate(Axis.Z, -150);
	    tibia3Left.rotate(Axis.X, 100);
	    tibia3Left.rotate(Axis.Y, 150);
	    tibia3Left.rotate(Axis.Z, -150);
	    tarsus3Left.rotate(Axis.X, 100);
	    tarsus3Left.rotate(Axis.Y, -90);
	    tarsus3Left.rotate(Axis.Z, -150);
	    
	    femur3Right.rotate(Axis.X, 100);
	    femur3Right.rotate(Axis.Y, -150);
	    femur3Right.rotate(Axis.Z, -150);
	    tibia3Right.rotate(Axis.X, 100);
	    tibia3Right.rotate(Axis.Y, 150);
	    tibia3Right.rotate(Axis.Z, -150);
	    tarsus3Right.rotate(Axis.X, 100);
	    tarsus3Right.rotate(Axis.Y, -360);
	    tarsus3Right.rotate(Axis.Z, -150);
	    
	    // set rotation limits for the head.
	    this.head.setXPositiveExtent(10);
	    this.head.setXNegativeExtent(-10);
	    this.head.setYPositiveExtent(25);
	    this.head.setYNegativeExtent(-25);
	    this.head.setZPositiveExtent(10);
	    this.head.setZNegativeExtent(-10);
	    
	    // set rotation limits for the body.
	    this.body.setXPositiveExtent(0);
	    this.body.setXNegativeExtent(0);
	    this.body.setZPositiveExtent(0);
	    this.body.setZNegativeExtent(0);
	    
	    // set rotation limits for the tail.
	    this.tail.setXPositiveExtent(0);
	    this.tail.setXNegativeExtent(0);
	    this.tail.setYPositiveExtent(0);
	    this.tail.setYNegativeExtent(0);
	    this.tail.setZPositiveExtent(0);
	    this.tail.setZNegativeExtent(0);

	    //set the rotation limits for the femur joint 
	    for (final Component femur : Arrays.asList(femur1Left,femur2Left,femur3Left)){
	    	femur.setXPositiveExtent(130);
		    femur.setXNegativeExtent(50);
		    femur.setYPositiveExtent(150);
		    femur.setYNegativeExtent(150);
		    femur.setZPositiveExtent(-150);
		    femur.setZNegativeExtent(-150);
	    }
	    
	    for (final Component femur : Arrays.asList(femur1Right,femur2Right,femur3Right)){
	    	femur.setXPositiveExtent(130);
		    femur.setXNegativeExtent(50);
		    femur.setYPositiveExtent(-150);
		    femur.setYNegativeExtent(-150);
		    femur.setZPositiveExtent(150);
		    femur.setZNegativeExtent(150);
	    }
	    
	    //set the rotation limits for the tibia joint 
	    for (final Component tibia : Arrays.asList(tibia1Left,tibia2Left,tibia3Left)){
	        tibia.setXPositiveExtent(190);
		    tibia.setXNegativeExtent(100);
		    tibia.setYPositiveExtent(180);
		    tibia.setYNegativeExtent(180);
		    tibia.setZPositiveExtent(-150);
		    tibia.setZNegativeExtent(-150);
	    }
	    
	    for (final Component tibia : Arrays.asList(tibia1Right,tibia2Right,tibia3Right)){
	        tibia.setXPositiveExtent(190);
		    tibia.setXNegativeExtent(100);
		    tibia.setYPositiveExtent(180);
		    tibia.setYNegativeExtent(180);
		    tibia.setZPositiveExtent(-150);
		    tibia.setZNegativeExtent(-150);
	    }
	    
	    //set the rotation limits for the tarsus joint 
	    for (final Component tarsus : Arrays.asList(tarsus1Left,tarsus2Left,tarsus3Left)){
	        tarsus.setXPositiveExtent(30);
		    tarsus.setXNegativeExtent(-30);
		    tarsus.setYPositiveExtent(30);
		    tarsus.setYNegativeExtent(-30);
		    tarsus.setZPositiveExtent(30);
		    tarsus.setZNegativeExtent(-30);
	    }
	    
	    //set the rotation limits for the tarsus joint 
	    for (final Component tarsus : Arrays.asList(tarsus1Right,tarsus2Right,tarsus3Right)){
	        tarsus.setXPositiveExtent(30);
		    tarsus.setXNegativeExtent(-30);
		    tarsus.setYPositiveExtent(30);
		    tarsus.setYNegativeExtent(-30);
		    tarsus.setZPositiveExtent(30);
		    tarsus.setZNegativeExtent(-30);
	    }
	    
	    //set the rotation limits for the wings 
	    for (final Component wing : Arrays.asList(foreWingLeft,hindWingLeft)){
	        wing.setXPositiveExtent(0);
		    wing.setXNegativeExtent(0);
		    wing.setYPositiveExtent(0);
		    wing.setYNegativeExtent(0);
		    wing.setZPositiveExtent(15);
		    wing.setZNegativeExtent(-30);
	    }
	    
	    for (final Component wing : Arrays.asList(foreWingRight, hindWingRight)){
	        wing.setXPositiveExtent(0);
		    wing.setXNegativeExtent(0);
		    wing.setYPositiveExtent(0);
		    wing.setYNegativeExtent(0);
		    wing.setZPositiveExtent(30);
		    wing.setZNegativeExtent(-15);
	    }
	    
	    //create the list of all the components for debugging purposes
	    this.components = Arrays.asList(femur1Left,femur1Right,femur2Left,femur2Right,femur3Left,femur3Right,
	    		tibia1Left,tibia1Right,tibia2Left,tibia2Right,tibia3Left,tibia3Right,
	    		tarsus1Left,tarsus1Right,tarsus2Left,tarsus2Right,tarsus3Left,tarsus3Right,
	    		foreWingLeft, foreWingRight, hindWingLeft, hindWingRight,
	    		this.head, this.body, this.tail);
	    		
	}
	private class Legs{
		private final Component femurJoint;
		private final Component tibiaJoint;
		private final Component tarsusJoint;
		private final List<Component> joints;
		
		public Legs(final Component femurJoint, final Component tibiaJoint, final Component tarsusJoint) {
			this.femurJoint = femurJoint;
			this.tibiaJoint = tibiaJoint;
			this.tarsusJoint = tarsusJoint;
			
		    this.joints = Collections.unmodifiableList(Arrays.asList(this.femurJoint,
			          this.tibiaJoint, this.tarsusJoint));
		}
		
		Component femurJoint() {
			return this.femurJoint;
		}
		Component tibiaJoint() {
			return this.tibiaJoint;
		}
		Component tarsusJoint() {
			return this.tarsusJoint;
		}
		List<Component> joints(){
			return this.joints;
		}
	}
	
	private class Wings{
		private final Component bodyJoint;
		public Wings(final Component bodyJoint) {
			this.bodyJoint = bodyJoint;
		}
		
		Component bodyJoint() {
			return this.bodyJoint;
		}
	}
}
