package Model;

import java.awt.Point;

public class TetrisBlock {
	
	public static final Point[][][] Shapes = {
			// I-Piece
			{
				{ new Point(-1, 1), new Point(0, 1), new Point(1, 1), new Point(2, 1) },
				{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3) },
				{ new Point(-1, 1), new Point(0, 1), new Point(1, 1), new Point(2, 1) },
				{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3) }
			},
			
			// J-Piece
			{
				{ new Point(2, 0), new Point(0, 1), new Point(1, 1), new Point(2, 1) },    
				{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 2) },
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 2) },
				{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 0) }
			},
			
			// L-Piece
			{
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 2) },
				{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 2) },
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 0) },
				{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 0) }
			},
			
			// O-Piece
			{
				{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
				{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
				{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
				{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) }
			},
			
			// S-Piece
			{
				{ new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1) },
				{ new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) },
				{ new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1) },
				{ new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) }
			},
			
			// T-Piece
			{
				{ new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(2, 1) },
				{ new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) },
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(1, 2) },
				{ new Point(1, 0), new Point(1, 1), new Point(2, 1), new Point(1, 2) }
			},
			
			// Z-Piece
			{
				{ new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1) },
				{ new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2) },
				{ new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1) },
				{ new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2) }
			}
	};
	
	public static final int START_POSITION_X = 5;
	public static final int START_POSITION_Y = 0;
	public static final int START_ROTATION = 0;
	
	private Point position;
	private int kind;
	private int rotation;
	
	public TetrisBlock(int kind) {
		
		this.position = new Point(START_POSITION_X, START_POSITION_Y);
		this.kind = kind;
		this.rotation = START_ROTATION;
		
	}
	
	public TetrisBlock(Point position, int kind, int rotation) {
		
		this.position = position;
		this.kind = kind;
		this.rotation = rotation;
		
	}
	
	public Point getPosition() {
		
		return position;
		
	}
	
	public int getKind() {
		
		return kind;
		
	}
	
	public int getRotation() {
		
		return rotation;
		
	}
	
	public void setPosition(Point position) {
		
		this.position = position;
		
	}
	
	public void setKind(int kind) {
		
		this.kind = kind;
		
	}
	
	public void setRotation(int rotation) {
		
		this.rotation = rotation;
		
	}
	
	public void move(int i) {
		
		position.x += i;
		
	}
	
	public void drop() {
		
		position.y++;
		
	}
	
	public Point[] getShape() {
		
		return Shapes[kind][rotation];
		
	}
	
	public Point[] getShapeWithRotation(int rotation) {
		
		return Shapes[kind][rotation];
		
	}
	
	public static Point[] getShape(int kind) {
		
		return Shapes[kind][0];
		
	}
	
}