/**
 * Copyright (c) 2016-present, RxJava Contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See
 * the License for the specific language governing permissions and limitations under the License.
 */

package io.reactivex.interop.internal.operators;

import static io.reactivex.interop.RxJava3Interop.*;
import org.junit.Test;

import io.reactivex.common.functions.BiFunction;
import io.reactivex.common.internal.functions.Functions;
import io.reactivex.flowable.Flowable;
import io.reactivex.interop.TestHelper;

public class FlowableReduceWithSingleTest {

    @Test
    public void normal() {
        reduceWith(Flowable.range(1, 5)
        , Functions.justCallable(1), new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer a, Integer b) throws Exception {
                return a + b;
            }
        })
        .test()
        .assertResult(16);
    }

    @Test
    public void disposed() {
        TestHelper.checkDisposed(reduceWith(Flowable.range(1, 5)
        , Functions.justCallable(1), new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer a, Integer b) throws Exception {
                return a + b;
            }
        }));
    }
}
