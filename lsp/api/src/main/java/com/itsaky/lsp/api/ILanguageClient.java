/*
 *  This file is part of AndroidIDE.
 *
 *  AndroidIDE is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  AndroidIDE is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *   along with AndroidIDE.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.itsaky.lsp.api;

import androidx.annotation.Nullable;

import com.itsaky.lsp.models.CodeActionItem;
import com.itsaky.lsp.models.DiagnosticItem;
import com.itsaky.lsp.models.DiagnosticResult;
import com.itsaky.lsp.models.ShowDocumentParams;
import com.itsaky.lsp.models.ShowDocumentResult;

import java.io.File;

/**
 * A language client handles notifications and events from a {@link ILanguageServer}.
 *
 * @author Akash Yadav
 */
public interface ILanguageClient {

  /**
   * Publish the diagnostics result (allow the user to see them).
   *
   * @param result The diagnostic result.
   */
  void publishDiagnostics(DiagnosticResult result);

  /**
   * Get the diagnostic item in the given file at the given character position.
   *
   * @param file The file to search diagnostics in.
   * @param line The line.
   * @param column The column.
   * @return The diagnostic item or <code>null</code> if none was found.
   */
  @Nullable
  DiagnosticItem getDiagnosticAt(File file, int line, int column);

  /**
   * Perform the given code action.
   *
   * @param file The file in which the given action must be performed.
   * @param actionItem The action item describing the action.
   */
  void performCodeAction(File file, CodeActionItem actionItem);

  /**
   * Notification sent by the language server to tell the client that it should open the given file
   * and select the range from the params.
   *
   * @param params The params for showing the document.
   * @return The result of the show document request. Servers can use this result to perform further
   *     action.
   */
  ShowDocumentResult showDocument(ShowDocumentParams params);
}
