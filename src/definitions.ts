export interface CleverTapCustomPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
