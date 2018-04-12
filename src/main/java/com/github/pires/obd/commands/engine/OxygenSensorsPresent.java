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
package com.github.pires.obd.commands.engine;

import com.github.pires.obd.commands.ObdCommand;
import com.github.pires.obd.enums.AvailableCommandNames;

/**
 * Fuel System Status.
 *
 */
public class OxygenSensorsPresent extends ObdCommand {

    private String result = "NODATA";

    /**
     * Default ctor.
     */
    public OxygenSensorsPresent() {
        super("01 13");
    }

    /**
     * Copy ctor.
     *
     * @param other a {@link OxygenSensorsPresent} object.
     */
    public OxygenSensorsPresent(OxygenSensorsPresent other) {
        super(other);
    }

    /** {@inheritDoc} */
    @Override
    protected void performCalculations() {

    }

    /** {@inheritDoc} */
    @Override
    public String getFormattedResult() {
        //First 4 characters are a copy of the command code, don't return those
        return String.valueOf(rawData).substring(4);
    }

    /** {@inheritDoc} */
    @Override
    public String getCalculatedResult() {
        //First 4 characters are a copy of the command code, don't return those
        return String.valueOf(rawData).substring(4);
    }


    /** {@inheritDoc} */
    @Override
    public String getResultUnit() {
        return "[1]";
    }

    /** {@inheritDoc} */
    @Override
    public String getName() {
        return AvailableCommandNames.OXYGEN_SENSORS_PRESENT.getValue();
    }

}
