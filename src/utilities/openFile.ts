import * as vscode from "vscode"
import * as path from "path"
import * as fs from "fs"

export function openFileInEditor(
	fileName: string,
	/*focusName:string,*/ startLine: number,
	endLine: number
) {
	let root
	if (vscode.workspace.workspaceFolders?.length === 1) {
		root = vscode.workspace.workspaceFolders[0].uri.fsPath
	} else {
		root = ""
	}
	const filePath = path.join(root, "pcms", fileName + ".aurora")
	if (fs.existsSync(filePath)) {
		const openPath = vscode.Uri.file(filePath)
		vscode.workspace.openTextDocument(openPath).then((doc) => {
			try {
				vscode.window
					.showTextDocument(doc, undefined, true)
					.then((editor) => {
						editor.selection = new vscode.Selection(
							editor.document.lineAt(startLine - 1).range.start,
							editor.document.lineAt(endLine - 1).range.end
						)
						// vscode.commands.executeCommand(focusName)
					})
			} catch (e: any) {
				console.log(
					"error catch?"
				) /* Fake error occurs, saying can not open when it does. This silences it */
			}
		})
	} else {
		fs.writeFile(
			filePath,
			"Clinical:\n\nIssues:\n\nOrders:\n",
			{ flag: "wx" },
			function (err) {
				if (err) throw err
				const openPath = vscode.Uri.file(filePath)
				vscode.workspace
					.openTextDocument(openPath)
					.then((doc) =>
						vscode.window.showTextDocument(doc).then((x) => {})
					)
				vscode.window.showInformationMessage(
					"Successfully created " + fileName + ".aurora"
				)
				// vscode.commands.executeCommand(focusName)
			}
		)
	}
}
