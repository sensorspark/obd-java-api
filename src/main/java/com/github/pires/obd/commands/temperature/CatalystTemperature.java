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
package com.github.pires.obd.commands.temperature;

import com.github.pires.obd.commands.ObdCommand;
import com.github.pires.obd.enums.AvailableCommandNames;

import java.text.DecimalFormat;
import java.util.Locale;

/**
 * Catalyst temperature. Caution: extends from OBDCommand
 *
 */
public class CatalystTemperature extends ObdCommand {

    private float cat_temp = 0;

    /**
     * <p>Constructor for CatalystTemperature.</p>
     */
    public CatalystTemperature() {
        super("01 3C");
    }

    /** {@inheritDoc} */
    @Override
    protected void performCalculations() {
        // ignore first two bytes [01 3C] of the response
        float A = buffer.get(2);
        float B = buffer.get(3);
        cat_temp = (((A * 256) + B)/10) - 40.0f;
    }

    /** {@inheritDoc} */
    @Override
    public String getFormattedResult() {
        return String.format("%.2f", cat_temp) + "Celsius";
    }

    /** {@inheritDoc} */
    @Override
    public String getCalculatedResult() {
        if(cat_temp > 0.0)
            return String.format(Locale.US, "%.2f", cat_temp);
        else
            return  "NODATA";
    }



    /**
     * <p>getAirFuelRatio.</p>
     *
     * @return a double.
     */
    public double getCatalystTemperature() {
        return cat_temp;
    }

    /** {@inheritDoc} */
    @Override
    public String getName() {
        return AvailableCommandNames.CATALYST_TEMPERATURE.getValue();
    }

}
