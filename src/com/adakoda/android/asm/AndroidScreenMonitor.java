/*
 * Copyright (C) 2009-2013 adakoda
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
package com.adakoda.android.asm;

import java.awt.Font;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class AndroidScreenMonitor {
	
	private MainFrame mMainFrame;
	private static String[] mArgs;

	public AndroidScreenMonitor() {
	}
	
	public void initialize() {
		Font font = new Font("楷体",Font.PLAIN,15);
        UIManager.put("Button.font", font);
        UIManager.put("Menu.font", font);
        UIManager.put("MenuItem.font", font);
		mMainFrame = new MainFrame(mArgs);
		mMainFrame.setLocationRelativeTo(null);
		mMainFrame.setVisible(true);//显示或隐藏这个窗口的值取决于参数b。
		mMainFrame.setFocusable(true);//设置为指定值的这一部分的聚焦状态。此值覆盖组件的默认集中度。

		mMainFrame.selectDevice();
	}
	
	public static void main(String[] args) {
		mArgs = args;
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AndroidScreenMonitor().initialize();
            }
        });
	}
}
