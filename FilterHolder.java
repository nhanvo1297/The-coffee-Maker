/* Filter Holder class represents for filter holder in coffee maker
 * @author Nhan Vo
 */

package FilterHolder;

public class FilterHolder {
	FilterHolderStatus status;
	// Default constructor of filter holder(Empty)
	public FilterHolder() {
		status=FilterHolderStatus.EMPTY;
	}
	//Method to set (EMpty) state for filter holder
	public void setFilterHolderEmpty() {
		status=FilterHolderStatus.EMPTY;
	}
	// Method to set(notEmpty) state for filter holder
	public void setFilterHolderNotEmpty() {
		status=FilterHolderStatus.NOTEMPTY;
	}
	//Method to check whether filter holder is empty or not.
	public boolean isFilterHolderEmpty() {
		if(status==FilterHolderStatus.EMPTY) {
			return true;
		}
		else {
			return false;
		}
	}
}
