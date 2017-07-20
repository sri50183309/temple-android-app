/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.home;

import java.util.HashMap;
import java.util.Map;

import android.app.ExpandableListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.ExpandableListContextMenuInfo;
import android.widget.TextView;
import android.widget.Toast;

import com.android.R;
import com.android.divyadesam1.AroundChennai;
import com.android.divyadesam1.AroundKumbakonam;
import com.android.divyadesam1.AroundMadurai;
import com.android.divyadesam1.AroundMayavaram;
import com.android.divyadesam1.AroundSeerghazi;
import com.android.divyadesam1.AroundTrichy;
import com.android.divyadesam1.Guidance;
import com.android.divyadesam2.AroundAndraPradesh;
import com.android.divyadesam2.AroundCuddalore;
import com.android.divyadesam2.AroundKanchipuram;
import com.android.divyadesam2.AroundKerla;
import com.android.divyadesam2.AroundTirunelveli;
import com.android.divyadesam2.InKancheepuram;
import com.android.divyadesam2.NorthIndia;
import com.android.famoustemple.AroundRameswaram;
import com.android.famoustemple.AroundTanjore;
import com.android.famoustemple.AroundTiruvanamalai;
import com.android.kumbakonam.Around100KM;
import com.android.kumbakonam.Around10KM;
import com.android.kumbakonam.Around25KM;
import com.android.kumbakonam.Around40KM;
import com.android.kumbakonam.Around60KM;
import com.android.kumbakonam.InKumbakonam;
import com.android.misc.AboutUs;
import com.android.misc.ContactInfos;
import com.android.misc.FAQs;
import com.android.misc.MuruganTemple;
import com.android.navagraha.NavagrahaHome;
import com.android.navagraha.NavagrahaMaps;
import com.android.navagraha.NavagrahaTempleInfos;
import com.android.navagraha.TourPackages;
import com.android.onlinepooja.PoojaBooking;
import com.android.onlinepooja.SpecialPooja;

/**
 * Demonstrates expandable lists using a custom {@link ExpandableListAdapter}
 * from {@link BaseExpandableListAdapter}.
 */
public class ExpandableList1 extends ExpandableListActivity {

    ExpandableListAdapter mAdapter;

    Map<String, Integer> finalIntentMap = new HashMap<String, Integer>();
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    	
    	finalIntentMap.put(getResources().getStringArray(R.array.homepage_list_array)[0], new Integer(0));
        finalIntentMap.put(getResources().getStringArray(R.array.homepage_list_array)[1], new Integer(1));
        finalIntentMap.put(getResources().getStringArray(R.array.homepage_list_array)[2], new Integer(2));
        finalIntentMap.put(getResources().getStringArray(R.array.homepage_list_array)[3], new Integer(3));
        finalIntentMap.put(getResources().getStringArray(R.array.homepage_list_array)[4], new Integer(4));
        finalIntentMap.put(getResources().getStringArray(R.array.homepage_list_array)[5], new Integer(5));
        finalIntentMap.put(getResources().getStringArray(R.array.homepage_list_array)[6], new Integer(6));
        
        // Set up our adapter
        mAdapter = new MyExpandableListAdapter();
        setListAdapter(mAdapter);
        registerForContextMenu(getExpandableListView());
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Sample menu");
        menu.add(0, 0, 0, R.string.app_name);
    }
    
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        ExpandableListContextMenuInfo info = (ExpandableListContextMenuInfo) item.getMenuInfo();

        String title = ((TextView) info.targetView).getText().toString();
        
        int type = ExpandableListView.getPackedPositionType(info.packedPosition);
        if (type == ExpandableListView.PACKED_POSITION_TYPE_CHILD) {
            int groupPos = ExpandableListView.getPackedPositionGroup(info.packedPosition); 
            int childPos = ExpandableListView.getPackedPositionChild(info.packedPosition); 
            Toast.makeText(this, title + ": Child " + childPos + " clicked in group " + groupPos,
                    Toast.LENGTH_SHORT).show();
            return true;
        } else if (type == ExpandableListView.PACKED_POSITION_TYPE_GROUP) {
            int groupPos = ExpandableListView.getPackedPositionGroup(info.packedPosition); 
            Toast.makeText(this, title + ": Group " + groupPos + " clicked", Toast.LENGTH_SHORT).show();
            return true;
        }
        
        return false;
    }

    
    @Override
	public boolean onChildClick(ExpandableListView parent, View v,
			int groupPosition, int childPosition, long id) {
    	String childEventName = (String)mAdapter.getChild(groupPosition, childPosition);
    	String parentName = (String)mAdapter.getGroup(groupPosition);
    	
//    	AlertDialog.Builder alt_bld = new AlertDialog.Builder(this);
//    	alt_bld.setMessage("Do you want to close this window ?"+parentName);
//    	alt_bld.show();
    	
    	switch (finalIntentMap.get(parentName)) {
		case 0:
			transferActivityForKumbakonam(childEventName);
			break;
		case 1:
			transferActivtyForDivyaDesam1(childEventName);
			break;
		case 2:
			transferActivityForDivyaDesam2(childEventName);
			break;
		case 3:
			if(childEventName.equalsIgnoreCase("Home Page")){
				Intent intent = new Intent(ExpandableList1.this, NavagrahaHome.class);
		    	ExpandableList1.this.startActivity(intent);
			}else if(childEventName.equalsIgnoreCase("Temple Infos")){
				Intent intent = new Intent(ExpandableList1.this, NavagrahaTempleInfos.class);
		    	ExpandableList1.this.startActivity(intent);
			}else if(childEventName.equalsIgnoreCase("Tour Packages")){
				Intent intent = new Intent(ExpandableList1.this, TourPackages.class);
		    	ExpandableList1.this.startActivity(intent);
			}else if(childEventName.equalsIgnoreCase("Navagraha Maps")){
				Intent intent = new Intent(ExpandableList1.this, NavagrahaMaps.class);
		    	ExpandableList1.this.startActivity(intent);
			}
			break;
		case 4:
			if(childEventName.equalsIgnoreCase("Around Chennai")){
				Intent intent = new Intent(ExpandableList1.this, com.android.famoustemple.AroundChennai.class);
		    	ExpandableList1.this.startActivity(intent);
			}else if(childEventName.equalsIgnoreCase("Around Tanjore")){
				Intent intent = new Intent(ExpandableList1.this, AroundTanjore.class);
		    	ExpandableList1.this.startActivity(intent);
			}else if(childEventName.equalsIgnoreCase("Around Trichy")){
				Intent intent = new Intent(ExpandableList1.this, com.android.famoustemple.AroundTrichy.class);
		    	ExpandableList1.this.startActivity(intent);
			}else if(childEventName.equalsIgnoreCase("Around Tirunelveli")){
				Intent intent = new Intent(ExpandableList1.this, com.android.famoustemple.AroundTirunelveli.class);
		    	ExpandableList1.this.startActivity(intent);
			}else if(childEventName.equalsIgnoreCase("Around Madurai")){
				Intent intent = new Intent(ExpandableList1.this, com.android.famoustemple.AroundMadurai.class);
		    	ExpandableList1.this.startActivity(intent);
			}else if(childEventName.equalsIgnoreCase("Around Rameswaram")){
				Intent intent = new Intent(ExpandableList1.this, AroundRameswaram.class);
		    	ExpandableList1.this.startActivity(intent);
			}else if(childEventName.equalsIgnoreCase("Around Tiruvannamalai")){
				Intent intent = new Intent(ExpandableList1.this, AroundTiruvanamalai.class);
		    	ExpandableList1.this.startActivity(intent);
			}else if(childEventName.equalsIgnoreCase("Around Kanchipuram")){
				Intent intent = new Intent(ExpandableList1.this, com.android.famoustemple.AroundKanchipuram.class);
		    	ExpandableList1.this.startActivity(intent);
			}
			break;
		case 5:
			if(childEventName.equalsIgnoreCase("Special Pooja")){
				Intent intent = new Intent(ExpandableList1.this, SpecialPooja.class);
		    	ExpandableList1.this.startActivity(intent);
			}else if(childEventName.equalsIgnoreCase("Navagraha Temples")){
				Intent intent = new Intent(ExpandableList1.this, NavagrahaTempleInfos.class);
		    	ExpandableList1.this.startActivity(intent);
			}else if(childEventName.equalsIgnoreCase("Pooja Booking")){
				Intent intent = new Intent(ExpandableList1.this, PoojaBooking.class);
		    	ExpandableList1.this.startActivity(intent);
			}
			break;
		case 6:
			if(childEventName.equalsIgnoreCase("Murugan Temples")){
				Intent intent = new Intent(ExpandableList1.this, MuruganTemple.class);
		    	ExpandableList1.this.startActivity(intent);
			}else if(childEventName.equalsIgnoreCase("About Us")){
				Intent intent = new Intent(ExpandableList1.this, AboutUs.class);
		    	ExpandableList1.this.startActivity(intent);
			}else if(childEventName.equalsIgnoreCase("FAQs")){
				Intent intent = new Intent(ExpandableList1.this, FAQs.class);
		    	ExpandableList1.this.startActivity(intent);
			}else if(childEventName.equalsIgnoreCase("Contact Information")){
				Intent intent = new Intent(ExpandableList1.this, ContactInfos.class);
		    	ExpandableList1.this.startActivity(intent);
			}
			break;

		default:
			break;
		}
    	
    		
		return super.onChildClick(parent, v, groupPosition, childPosition, id);
	}

	private void transferActivityForDivyaDesam2(String childEventName) {
		if(childEventName.equalsIgnoreCase("Around Kerla")){
			Intent intent = new Intent(ExpandableList1.this, AroundKerla.class);
			ExpandableList1.this.startActivity(intent);
		}else if(childEventName.equalsIgnoreCase("Around Thirunelveli")){
			Intent intent = new Intent(ExpandableList1.this, AroundTirunelveli.class);
			ExpandableList1.this.startActivity(intent);
		}else if(childEventName.equalsIgnoreCase("Around Kanchipuram")){
			Intent intent = new Intent(ExpandableList1.this, AroundKanchipuram.class);
			ExpandableList1.this.startActivity(intent);
		}else if(childEventName.equalsIgnoreCase("North India")){
			Intent intent = new Intent(ExpandableList1.this, NorthIndia.class);
			ExpandableList1.this.startActivity(intent);
		}else if(childEventName.equalsIgnoreCase("In Kancheepuram")){
			Intent intent = new Intent(ExpandableList1.this, InKancheepuram.class);
			ExpandableList1.this.startActivity(intent);
		}else if(childEventName.equalsIgnoreCase("Near Cuddalore")){
			Intent intent = new Intent(ExpandableList1.this, AroundCuddalore.class);
			ExpandableList1.this.startActivity(intent);
		}else if(childEventName.equalsIgnoreCase("Andhra Pradesh")){
			Intent intent = new Intent(ExpandableList1.this, AroundAndraPradesh.class);
			ExpandableList1.this.startActivity(intent);
		}
	}

	private void transferActivityForKumbakonam(String childEventName) {
		if(childEventName.equalsIgnoreCase("In Kumbakonam")){
			Intent intent = new Intent(ExpandableList1.this, InKumbakonam.class);
			ExpandableList1.this.startActivity(intent);
		}else if(childEventName.equalsIgnoreCase("Around 10KM")){
			Intent intent = new Intent(ExpandableList1.this, Around10KM.class);
			ExpandableList1.this.startActivity(intent);
		}else if(childEventName.equalsIgnoreCase("Around 25KM")){
			Intent intent = new Intent(ExpandableList1.this, Around25KM.class);
			ExpandableList1.this.startActivity(intent);
		}else if(childEventName.equalsIgnoreCase("Around 40KM")){
			Intent intent = new Intent(ExpandableList1.this, Around40KM.class);
			ExpandableList1.this.startActivity(intent);
		}else if(childEventName.equalsIgnoreCase("Around 60KM")){
			Intent intent = new Intent(ExpandableList1.this, Around60KM.class);
			ExpandableList1.this.startActivity(intent);
		}else if(childEventName.equalsIgnoreCase("Around 100KM")){
			Intent intent = new Intent(ExpandableList1.this, Around100KM.class);
			ExpandableList1.this.startActivity(intent);
		}
	}

	private void transferActivtyForDivyaDesam1(String childEventName) {
		if(childEventName.equalsIgnoreCase("Guidance")){
			Intent intent = new Intent(ExpandableList1.this, Guidance.class);
			ExpandableList1.this.startActivity(intent);
		}else if(childEventName.equalsIgnoreCase("Around Kumbakonam")){
			Intent intent = new Intent(ExpandableList1.this, AroundKumbakonam.class);
			ExpandableList1.this.startActivity(intent);
		}else if(childEventName.equalsIgnoreCase("Around Seerghazi")){
			Intent intent = new Intent(ExpandableList1.this, AroundSeerghazi.class);
			ExpandableList1.this.startActivity(intent);
		}else if(childEventName.equalsIgnoreCase("Around Mayavaram")){
			Intent intent = new Intent(ExpandableList1.this, AroundMayavaram.class);
			ExpandableList1.this.startActivity(intent);
		}else if(childEventName.equalsIgnoreCase("Around Trichy")){
			Intent intent = new Intent(ExpandableList1.this, AroundTrichy.class);
			ExpandableList1.this.startActivity(intent);
		}else if(childEventName.equalsIgnoreCase("Around Chennai")){
			Intent intent = new Intent(ExpandableList1.this, AroundChennai.class);
			ExpandableList1.this.startActivity(intent);
		}else if(childEventName.equalsIgnoreCase("Around Madurai")){
			Intent intent = new Intent(ExpandableList1.this, AroundMadurai.class);
			ExpandableList1.this.startActivity(intent);
		}
	}

   
	/**
     * A simple adapter which maintains an ArrayList of photo resource Ids. 
     * Each photo is displayed as an image. This adapter supports clearing the
     * list of photos and adding a new photo.
     *
     */
    public class MyExpandableListAdapter extends BaseExpandableListAdapter {
        // Sample data set.  children[i] contains the children (String[]) for groups[i].
        //private String[] groups = { "Kumbakonam", "DivyaDesam1", "DivyaDesam2", "Famous Temples", "NavagrahaTemples", "Murugan Temples" };
        private String[] groups = getResources().getStringArray(R.array.homepage_list_array);
        private String[][] children = {
                getResources().getStringArray(R.array.kumbakonamArr),
                getResources().getStringArray(R.array.DivyaDesamArr1),
                getResources().getStringArray(R.array.DivyaDesamArr2),
                getResources().getStringArray(R.array.NavagrahaArr),
                getResources().getStringArray(R.array.FamousTempleArr),
                getResources().getStringArray(R.array.PoojaBookingArr),
                getResources().getStringArray(R.array.miscelleanousArr)
        };
        
        public Object getChild(int groupPosition, int childPosition) {
            return children[groupPosition][childPosition];
        }

        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        public int getChildrenCount(int groupPosition) {
        	if(children.length > groupPosition)
        		return children[groupPosition].length;
        	else
        		return 0;
        }

        public TextView getGenericView() {
            // Layout parameters for the ExpandableListView
            AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
                    ViewGroup.LayoutParams.FILL_PARENT, 64);

            TextView textView = new TextView(ExpandableList1.this);
            textView.setLayoutParams(lp);
            // Center the text vertically
            textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
            // Set the text starting position
            textView.setPadding(36, 0, 0, 0);
            return textView;
        }
        
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                View convertView, ViewGroup parent) {
            TextView textView = getGenericView();
            textView.setText(getChild(groupPosition, childPosition).toString());
            return textView;
        }

        public Object getGroup(int groupPosition) {
            return groups[groupPosition];
        }

        public int getGroupCount() {
            return groups.length;
        }

        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
                ViewGroup parent) {
            TextView textView = getGenericView();
            textView.setText(getGroup(groupPosition).toString());
            return textView;
        }

        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

        public boolean hasStableIds() {
            return true;
        }

    }
}
