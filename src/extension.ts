import { commands, ExtensionContext } from "vscode";
import { HelloWorldPanel } from "./panels/HelloWorldPanel";
import { AuroraProvider } from "./panels/provider";
import * as vscode from 'vscode';

export function activate(context: ExtensionContext) {
  // Create the show hello world command
  const showHelloWorldCommand = commands.registerCommand("hello-world.showHelloWorld", () => {
    HelloWorldPanel.render(context.extensionUri);
  });

  // Add command to the extension context
  context.subscriptions.push(showHelloWorldCommand);

    // Instantiate a new instance of the WeatherViewProvider class
    const provider = new AuroraProvider(context.extensionUri);

    // Register the provider for a Webview View
    const webviewViewDisposable = vscode.window.registerWebviewViewProvider( 
      AuroraProvider.viewType,
      provider,
      {
        webviewOptions:{
          retainContextWhenHidden: true
        }
      }
    );

    context.subscriptions.push(webviewViewDisposable);
}
