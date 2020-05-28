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
 * This event is sent by the caller when they wish to establish a call.
 */
@JsonClass(generateAdapter = true)
data class CallInviteContent(
        /**
         * Required. A unique identifier for the call.
         */
        @Json(name = "call_id") val callId: String?,
        /**
         * Required. The session description object
         */
        @Json(name = "version") val version: Int?,
        /**
         * Required. The version of the VoIP specification this message adheres to. This specification is version 0.
         */
        @Json(name = "lifetime") val lifetime: Int?,
        /**
         * Required. The time in milliseconds that the invite is valid for.
         * Once the invite age exceeds this value, clients should discard it.
         * They should also no longer show the call as awaiting an answer in the UI.
         */
        @Json(name = "offer") val offer: Offer?
) {
    @JsonClass(generateAdapter = true)
    data class Offer(
            /**
             * Required. The type of session description. Must be 'offer'.
             */
            @Json(name = "type") val type: String?,
            /**
             * Required. The SDP text of the session description.
             */
            @Json(name = "sdp") val sdp: String?
    ) {
        companion object {
            const val SDP_VIDEO = "m=video"
        }
    }

    fun isVideo(): Boolean = offer?.sdp?.contains(Offer.SDP_VIDEO) == true
}
