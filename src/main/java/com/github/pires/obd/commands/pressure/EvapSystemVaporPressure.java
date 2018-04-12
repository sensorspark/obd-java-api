/**
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.github.pires.obd.commands.pressure;

import com.github.pires.obd.enums.AvailableCommandNames;

/**
 * <p>EvapSystemVaporPressure class.</p>
 *
 */
public class EvapSystemVaporPressure extends PressureCommand {

    /**
     * <p>Constructor for EvapSystemVaporPressure.</p>
     */
    public EvapSystemVaporPressure() {
        super("01 32");
    }

    /**
     * <p>Constructor for EvapSystemVaporPressure.</p>
     *
     * @param other a {@link EvapSystemVaporPressure} object.
     */
    public EvapSystemVaporPressure(EvapSystemVaporPressure other) {
        super(other);
    }

    /**
     * {@inheritDoc}
     * <p>
     */
    @Override
    protected final int preparePressureValue() {
        int a = buffer.get(2);
        int b = buffer.get(3);
        return ((a * 256) + b)/4;
    }

    /** {@inheritDoc} */
    @Override
    public String getName() {
        return AvailableCommandNames.EVAPORATIVE_VAPOR_SYSTEM_PRESSURE.getValue();
    }

}
