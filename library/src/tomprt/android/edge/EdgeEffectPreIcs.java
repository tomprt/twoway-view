/*
 * Copyright (C) 2011 The Android Open Source Project
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
package tomprt.android.edge;

import android.content.Context;
import android.graphics.Canvas;

/**
 * Stub implementation that contains a backported EdgeEffect for API10
 * 
 * This class is an implementation detail for EdgeEffectCompat and should not be
 * used directly.
 */
class EdgeEffectCompactPreIcs {
	public static Object newEdgeEffect(Context context) {
		return new EdgeEffectBackport(context);
	}

	public static void setSize(Object edgeEffect, int width, int height) {
		((EdgeEffectBackport) edgeEffect).setSize(width, height);
	}

	public static boolean isFinished(Object edgeEffect) {
		return ((EdgeEffectBackport) edgeEffect).isFinished();
	}

	public static void finish(Object edgeEffect) {
		((EdgeEffectBackport) edgeEffect).finish();
	}

	public static boolean onPull(Object edgeEffect, float deltaDistance) {
		((EdgeEffectBackport) edgeEffect).onPull(deltaDistance);
		return true;
	}

	public static boolean onRelease(Object edgeEffect) {
		EdgeEffectBackport eff = (EdgeEffectBackport) edgeEffect;
		eff.onRelease();
		return eff.isFinished();
	}

	public static boolean onAbsorb(Object edgeEffect, int velocity) {
		((EdgeEffectBackport) edgeEffect).onAbsorb(velocity);
		return true;
	}

	public static boolean draw(Object edgeEffect, Canvas canvas) {
		return ((EdgeEffectBackport) edgeEffect).draw(canvas);
	}
}