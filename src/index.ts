import { registerPlugin } from '@capacitor/core';

import type { CleverTapCustomPlugin } from './definitions';

const CleverTapCustom = registerPlugin<CleverTapCustomPlugin>('CleverTapCustom', {
  web: () => import('./web').then((m) => new m.CleverTapCustomWeb()),
});

export * from './definitions';
export { CleverTapCustom };
