import javax.media.opengl.GL2;

import com.jogamp.opengl.util.gl2.GLUT;//for new version of gl


public class Body extends Circular implements Displayable {
	private int callListHandle;
	
	public Body(final double radius, final GLUT glut) {
		super(radius, glut);
	}

	@Override
	public void draw(GL2 gl) {
		gl.glCallList(this.callListHandle);
	}
	@Override
	public void initialize(GL2 gl) {
		// TODO Auto-generated method stub
		this.callListHandle = gl.glGenLists(1);
		
		gl.glNewList(this.callListHandle, GL2.GL_COMPILE);
		gl.glPushMatrix();
		//put the body above the x and y plane
		gl.glTranslated(0 , 0, this.radius());
		gl.glScalef(1f, 0.8f, 1.8f);
		this.glut().glutSolidSphere(this.radius(), 36, 18);
		gl.glPopMatrix();
		gl.glEndList();
	}
}