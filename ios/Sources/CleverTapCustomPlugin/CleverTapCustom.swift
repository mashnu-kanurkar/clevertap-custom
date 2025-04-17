import Foundation

@objc public class CleverTapCustom: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
