# clevertap-custom

clevertap custom plugin

## Install

```bash
npm install clevertap-custom
npx cap sync
```

## API

<docgen-index>

* [`echo(...)`](#echo)
* [`pushEvent(...)`](#pushevent)
* [`onUserLogin(...)`](#onuserlogin)
* [`createNotificationChannel()`](#createnotificationchannel)
* [`addListener('onPushClicked', ...)`](#addlisteneronpushclicked-)
* [`removeAllListeners()`](#removealllisteners)
* [Interfaces](#interfaces)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### echo(...)

```typescript
echo(options: { value: string; }) => Promise<{ value: string; }>
```

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ value: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### pushEvent(...)

```typescript
pushEvent(data: { eventName: string; eventProps: { [key: string]: any; }; }) => Promise<void>
```

| Param      | Type                                                                     |
| ---------- | ------------------------------------------------------------------------ |
| **`data`** | <code>{ eventName: string; eventProps: { [key: string]: any; }; }</code> |

--------------------


### onUserLogin(...)

```typescript
onUserLogin(data: { userProps: { [key: string]: any; }; }) => Promise<void>
```

| Param      | Type                                                 |
| ---------- | ---------------------------------------------------- |
| **`data`** | <code>{ userProps: { [key: string]: any; }; }</code> |

--------------------


### createNotificationChannel()

```typescript
createNotificationChannel() => Promise<void>
```

--------------------


### addListener('onPushClicked', ...)

```typescript
addListener(eventName: 'onPushClicked', listenerFunc: (data: any) => void) => Promise<PluginListenerHandle>
```

| Param              | Type                                |
| ------------------ | ----------------------------------- |
| **`eventName`**    | <code>'onPushClicked'</code>        |
| **`listenerFunc`** | <code>(data: any) =&gt; void</code> |

**Returns:** <code>Promise&lt;<a href="#pluginlistenerhandle">PluginListenerHandle</a>&gt;</code>

--------------------


### removeAllListeners()

```typescript
removeAllListeners() => Promise<void>
```

--------------------


### Interfaces


#### PluginListenerHandle

| Prop         | Type                                      |
| ------------ | ----------------------------------------- |
| **`remove`** | <code>() =&gt; Promise&lt;void&gt;</code> |

</docgen-api>
