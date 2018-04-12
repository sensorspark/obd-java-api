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
 * <p>FuelRailPressureCommand0122 class.</p>
 *
 */
public class FuelRailPressureCommand0122 extends PressureCommand {

    /**
     * <p>Constructor for FuelRailPressureCommand.</p>
     */
    public FuelRailPressureCommand0122() {
        super("01 22");
    }

    /**
     * <p>Constructor for FuelRailPressureCommand.</p>
     *
     * @param other a {@link FuelRailPressureCommand0122} object.
     */
    public FuelRailPressureCommand0122(FuelRailPressureCommand0122 other) {
        super(other);
    }

    /**
     * {@inheritDoc}
     * <p>
     * TODO describe of why we multiply by 3
     */
    @Override
    protected final int preparePressureValue() {
        int a = buffer.get(2);
        int b = buffer.get(3);
        return ((a * 256) + b) * 10;
    }

    /** {@inheritDoc} */
    @Override
    public String getName() {
        return AvailableCommandNames.FUEL_RAIL_PRESSURE0122.getValue();
    }

}
