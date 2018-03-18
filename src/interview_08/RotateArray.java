package interview_08;
/**
 * 
 * @ClassName: RotateArray 
 * @Description: 
 * 题目:把一个数组最开始的若干个元素搬到数组的末尾，我们称之为
数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小
元素。例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值
为1。
 * @author cjm
 * @date 2017年11月23日 下午5:29:10 
 *
 */
public class RotateArray {
	public static void main(String[] args) {
//		int[] rotateArray = {4,5,1,2,3};
		int[] rotateArray = {1,0,1,1,1};
		int num = findSmallNum(rotateArray,0,rotateArray.length-1);
		System.out.println(num);
	}
	/**
	 * 
	 * @Title: findSmallNum 
	 * @Description: 查找旋转数组中的最小元素 
	 * @param rotateArray
	 * @return   
	 * @return int     
	 * @throws
	 */
	private static int findSmallNum(int[] rotateArray,int start,int end) {
		if(rotateArray == null)throw new RuntimeException("旋转数组不能为空");
		if(start>end)throw new RuntimeException("start和end出错");
		if(start == end)return rotateArray[start];
		if(end-start==1) {
			return rotateArray[start]>=rotateArray[end]?rotateArray[end]:rotateArray[start];
		}
		int mid = (start+end)/2;
		if(rotateArray[start]==rotateArray[mid] && rotateArray[mid]==rotateArray[end]) {// 退化为顺序查找
			int min = rotateArray[0];
			int length = rotateArray.length;
			for(int i =1;i<length;i++) {
				if(rotateArray[i]<min) {
					min = rotateArray[i];
				}
			}
			return min;
		}
		
		if(rotateArray[mid]>=rotateArray[start]) {//旋转位置在后半段
			return findSmallNum(rotateArray, mid, end);
		}else {//前半段
			return findSmallNum(rotateArray, start, mid);
		}
	}
}
