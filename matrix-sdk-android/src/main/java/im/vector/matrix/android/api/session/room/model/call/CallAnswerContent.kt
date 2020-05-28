/*
 * Copyright 2019 New Vector Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package im.vector.matrix.android.api.session.room.model.call

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * This event is sent by the callee when they wish to answer the call.
 */
@JsonClass(generateAdapter = true)
data class CallAnswerContent(
        /**
         * Required. The ID of the call this event relates to.
         */
        @Json(name = "call_id") val callId: String,
        /**
         * Required. The session description object
         */
        @Json(name = "answer") val answer: Answer,
        /**
         * Required. The version of the VoIP specification this messages adheres to. This specification is version 0.
         */
        @Json(name = "version") val version: Int
) {

    @JsonClass(generateAdapter = true)
    data class Answer(
            /**
             * Required. The type of session description. Must be 'answer'.
             */
            @Json(name = "type") val type: String,
            /**
             * Required. The SDP text of the session description.
             */
            @Json(name = "sdp") val sdp: String
    )
}
