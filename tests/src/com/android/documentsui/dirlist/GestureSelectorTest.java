/*
 * Copyright (C) 2016 The Android Open Source Project
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

package com.android.documentsui.dirlist;

import android.graphics.Point;
import android.test.AndroidTestCase;
import android.test.suitebuilder.annotation.SmallTest;
import android.view.View;

import com.android.documentsui.TestInputEvent;

@SmallTest
public class GestureSelectorTest extends AndroidTestCase {

    TestInputEvent e;

    // Simulate a (20, 20) box locating at (20, 20)
    static final int LEFT_BORDER = 20;
    static final int RIGHT_BORDER = 40;
    static final int TOP_BORDER = 20;
    static final int BOTTOM_BORDER = 40;

    @Override
    public void setUp() throws Exception {
        e = new TestInputEvent();
    }

    public void testLTRPastLastItem() {
        e.location = new Point(100, 100);
        assertTrue(GestureSelector.isPastLastItem(
                TOP_BORDER, LEFT_BORDER, RIGHT_BORDER, e, View.LAYOUT_DIRECTION_LTR));
    }

    public void testLTRPastLastItem_Inverse() {
        e.location = new Point(10, 10);
        assertFalse(GestureSelector.isPastLastItem(
                TOP_BORDER, LEFT_BORDER, RIGHT_BORDER, e, View.LAYOUT_DIRECTION_LTR));
    }

    public void testRTLPastLastItem() {
        e.location = new Point(10, 30);
        assertTrue(GestureSelector.isPastLastItem(
                TOP_BORDER, LEFT_BORDER, RIGHT_BORDER, e, View.LAYOUT_DIRECTION_RTL));
    }

    public void testRTLPastLastItem_Inverse() {
        e.location = new Point(100, 100);
        assertFalse(GestureSelector.isPastLastItem(
                TOP_BORDER, LEFT_BORDER, RIGHT_BORDER, e, View.LAYOUT_DIRECTION_RTL));
    }
}
