import { PluginListenerHandle } from "@capacitor/core";

export interface CleverTapCustomPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;

  pushEvent(data: {
    eventName: string;
    eventProps: { [key: string]: any };
  }): Promise<void>;

  onUserLogin(data: {
    userProps: { [key: string]: any };
  }): Promise<void>;

  createNotificationChannel(): Promise<void>;

  addListener(
    eventName: 'onPushClicked',
    listenerFunc: (data: any) => void
  ): Promise<PluginListenerHandle>;

  removeAllListeners(): Promise<void>;
}
