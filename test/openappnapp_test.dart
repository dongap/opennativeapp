import 'package:flutter_test/flutter_test.dart';
import 'package:openappnapp/openappnapp.dart';
import 'package:openappnapp/openappnapp_platform_interface.dart';
import 'package:openappnapp/openappnapp_method_channel.dart';
import 'package:plugin_platform_interface/plugin_platform_interface.dart';

class MockOpenappnappPlatform
    with MockPlatformInterfaceMixin
    implements OpenappnappPlatform {

  @override
  Future<String?> getPlatformVersion() => Future.value('42');
}

void main() {
  final OpenappnappPlatform initialPlatform = OpenappnappPlatform.instance;

  test('$MethodChannelOpenappnapp is the default instance', () {
    expect(initialPlatform, isInstanceOf<MethodChannelOpenappnapp>());
  });

  test('getPlatformVersion', () async {
    Openappnapp openappnappPlugin = Openappnapp();
    MockOpenappnappPlatform fakePlatform = MockOpenappnappPlatform();
    OpenappnappPlatform.instance = fakePlatform;

    expect(await openappnappPlugin.getPlatformVersion(), '42');
  });
}
