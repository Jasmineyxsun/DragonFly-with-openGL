import javax.media.opengl.GL2;

import com.jogamp.opengl.util.gl2.GLUT;

public class LeftWing extends Circular implements Displayable {
	private int callListHandle;
	
	public LeftWing(final double radius, final GLUT glut) {
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
		//gl.glTranslated(-1f ,-1f, -1f);
		gl.glTranslatef(0f, 0f, 1f);
		gl.glRotatef(90, 0, -1, 0);
		gl.glTranslatef(0f, 0f, -1f);
		gl.glScalef(0.9f, 0.2f, 2);
		this.glut().glutSolidSphere(this.radius(), 36, 18);
		gl.glPopMatrix();
		gl.glEndList();

	}
}

