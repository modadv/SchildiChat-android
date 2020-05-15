/*
 * Copyright 2019 New Vector Ltd
 *
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
 */

package im.vector.matrix.android.api.session.room.model.message

import im.vector.matrix.android.internal.crypto.model.rest.EncryptedFileInfo

/**
 * Interface for message which can contains an encrypted file
 */
interface MessageWithAttachmentContent : MessageContent {
    /**
     * Required if the file is unencrypted. The URL (typically MXC URI) to the image.
     */
    val url: String?

    /**
     * Required if the file is encrypted. Information on the encrypted file, as specified in End-to-end encryption.
     */
    val encryptedFileInfo: EncryptedFileInfo?
}

/**
 * Get the url of the encrypted file or of the file
 */
fun MessageWithAttachmentContent.getFileUrl() = encryptedFileInfo?.url ?: url