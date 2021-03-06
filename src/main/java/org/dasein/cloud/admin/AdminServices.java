/**
 * Copyright (C) 2009-2016 Dell, Inc.
 * See annotations for authorship information
 *
 * ====================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ====================================================================
 */

package org.dasein.cloud.admin;

import javax.annotation.Nullable;

public interface AdminServices {
    public @Nullable PrepaymentSupport getPrepaymentSupport();
    
    public boolean hasPrepaymentSupport();
    
    public @Nullable AccountSupport getAccountSupport();
    
    public boolean hasAccountSupport();
    
    public @Nullable BillingSupport getBillingSupport();
    
    public boolean hasBillingSupport();
}
