import {
	CancellationToken,
	Uri,
	Webview,
	WebviewView,
	WebviewViewProvider,
	WebviewViewResolveContext,
} from "vscode"
import { getUri } from "../utilities/getUri"
import { getNonce } from "../utilities/getNonce"
import { openFileInEditor } from "../utilities/openFile"

type BasicMessage = {
	command: string
	content: string
}

type OpenFileMessage = {
	command: string
	firstName: string
	lastName: string
	unitNumber: string
}

export class AuroraProvider implements WebviewViewProvider {
	public static readonly viewType = "aurora.patientTracker"

	constructor(private readonly _extensionUri: Uri) {}

	public resolveWebviewView(
		webviewView: WebviewView,
		context: WebviewViewResolveContext,
		_token: CancellationToken
	) {
		// Allow scripts in the webview
		webviewView.webview.options = {
			// Enable JavaScript in the webview
			enableScripts: true,

			// Restrict the webview to only load resources from the `out` directory
			// localResourceRoots: [Uri.joinPath(this._extensionUri, "out")],
		}

		// Set the HTML content that will fill the webview view
		webviewView.webview.html = this._getWebviewContent(
			webviewView.webview,
			this._extensionUri
		)

		// Sets up an event listener to listen for messages passed from the webview view context
		// and executes code based on the message that is recieved
		this._setWebviewMessageListener(webviewView)
	}

	private _getWebviewContent(webview: Webview, extensionUri: Uri) {
		// The CSS file from the React build output
		const stylesUri = getUri(webview, extensionUri, [
			"webview-ui",
			"build",
			"assets",
			"index.css",
		])
		// The JS file from the React build output
		const scriptUri = getUri(webview, extensionUri, [
			"webview-ui",
			"build",
			"assets",
			"index.js",
		])

		const nonce = getNonce()

		// Tip: Install the es6-string-html VS Code extension to enable code highlighting below
		return /*html*/ `
      <!DOCTYPE html>
      <html lang="en">
        <head>
          <meta charset="UTF-8" />
          <meta name="viewport" content="width=device-width, initial-scale=1.0" />
          <link rel="stylesheet" type="text/css" href="${stylesUri}">
          <title>Hello World</title>
        </head>
        <body>
          <div id="root"></div>
          <script type="module" nonce="${nonce}" src="${scriptUri}"></script>
        </body>
      </html>
    `
	}

	private _setWebviewMessageListener(webviewView: WebviewView) {
		webviewView.webview.onDidReceiveMessage((messageJson) => {
			const message: OpenFileMessage = JSON.parse(messageJson)
			console.log("got a message from the webview!")
			console.log(message)
			switch (message.command) {
				// case "hello":
				// 	// Code that should run in response to the hello message command
				// 	window.showInformationMessage(message.text)
				// 	return
				case "openFile":
					// Code that should run in response to the hello message command
					openFileInEditor(
						(message as OpenFileMessage).firstName +
							"_" +
							message.lastName +
							"_" +
							message.unitNumber,
						1,
						1
					)
					return
			}
			//   const command = message.command;
			//   const messageLifecycle = AllExtensionMessages.filter(lc => lc.id == command)
			//   messageLifecycle.length == 0? console.log("Message handler not found for: "+message.command) : messageLifecycle[0].onReceive(webviewView, message)
		})
	}
}
