import { WebPlugin } from '@capacitor/core';

import type { CleverTapCustomPlugin } from './definitions';

export class CleverTapCustomWeb extends WebPlugin implements CleverTapCustomPlugin {
  pushEvent(data: { eventName: string; eventProps: { [key: string]: any; }; }): Promise<void> {
    throw new Error('Method not implemented.');
  }
  onUserLogin(data: { userProps: { [key: string]: any; }; }): Promise<void> {
    throw new Error('Method not implemented.');
  }
  createNotificationChannel(): Promise<void> {
    throw new Error('Method not implemented.');
  }
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
