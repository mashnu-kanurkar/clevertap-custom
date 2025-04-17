import { WebPlugin } from '@capacitor/core';

import type { CleverTapCustomPlugin } from './definitions';

export class CleverTapCustomWeb extends WebPlugin implements CleverTapCustomPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
